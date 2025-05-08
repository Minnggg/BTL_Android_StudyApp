package com.example.btl_android_studyapp;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_android_studyapp.api.ApiClient;
import com.example.btl_android_studyapp.databinding.ActivityLogInBinding;
import com.example.btl_android_studyapp.model.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {
    ActivityLogInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.username.setText("B21DCCN535");
        binding.password.setText("Minhpn@1");

        binding.btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin", LENGTH_LONG).show();
                    return;
                }

                ApiClient.getInstance().getService().login(username,password,"password").enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        if(response.code() == 200) {
                            Contanst.userCurrent = response.body();
                            startActivity(new Intent(LogInActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(),"Đăng nhập không thành công, vui lòng thử lại.",LENGTH_LONG);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }
        });
    }
}