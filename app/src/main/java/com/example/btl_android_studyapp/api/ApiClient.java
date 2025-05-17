package com.example.btl_android_studyapp.api;

import android.util.Log;

import com.example.btl_android_studyapp.Contanst;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiClient {
    private static final String BASE_URL = "https://qldt.ptit.edu.vn/api/";
    private static ApiClient instance;
    private final ApiService apiService;

    private static OkHttpClient okHttpClient;

    static {
        try {
            final X509TrustManager trustAllCerts = new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            };

            TrustManager[] trustAllCertificates = new TrustManager[]{ trustAllCerts };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCertificates, new java.security.SecureRandom());

            okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(sslContext.getSocketFactory(), trustAllCerts) // ✅ Truyền đúng cả hai
                    .hostnameVerifier((hostname, session) -> true)
                    .addInterceptor(chain -> {
                        Response response = chain.proceed(chain.request());
                        String rawJson = response.body().string();
                        Log.d("RAW_JSON", rawJson);
                        ResponseBody newBody = ResponseBody.create(rawJson, response.body().contentType());
                        return response.newBuilder().body(newBody).build();
                    })
                    .addInterceptor(chain -> {
                        Request original = chain.request();
                        Request.Builder requestBuilder = original.newBuilder();
                        if (Contanst.userCurrent != null) {
                            requestBuilder.header("Authorization", "Bearer " + Contanst.userCurrent.getAccess_token());
                        }
                        Request request = requestBuilder.build();
                        return chain.proceed(request);
                    })
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }



    private ApiClient() {
        Gson gson = new GsonBuilder()
//                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }
        return instance;
    }

    public ApiService getService() {
        return apiService;
    }
}

