package com.example.btl_android_studyapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_android_studyapp.adapter.MessageAdapter;
import com.example.btl_android_studyapp.model.Message;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChatbotActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText messageEditText;
    private ImageButton sendButton;
    private ArrayList<Message> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;

    private final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chatbot);
        recyclerView = findViewById(R.id.recycler_view);
        messageEditText = findViewById(R.id.message_edit_text);
        sendButton = findViewById(R.id.send_btn);

        // Setup RecyclerView
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(ChatbotActivity.this);
        llm.setStackFromEnd(true);
        recyclerView.setLayoutManager(llm);

        addToChat("Xin chào, bạn hãy đặt câu hỏi, tôi sẽ trả lời thắc mắc đó của bạn ngay nhé!", Message.SENT_BY_BOT);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = messageEditText.getText().toString().trim();
                if (!question.isEmpty()) {
                    addToChat(question, Message.SENT_BY_ME);
                    addToChat("Typing...", Message.SENT_BY_BOT);
                    messageEditText.setText("");
                    callGeminiAPI(question);
                }
            }
        });
    }

    private void addToChat(String message, String sentBy) {
        new Handler(Looper.getMainLooper()).post(() -> {
            messageList.add(new Message(message, sentBy));
            for (Message msg : messageList) {
                Log.d("TAG", "Message: " + msg.getMessage() + ", Sent By: " + msg.getSentBy());
            }
            messageAdapter.notifyDataSetChanged();
            recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
        });
    }

    private void addResponse(String response) {
        if (!messageList.isEmpty()) {
            messageList.remove(messageList.size() - 1); // Remove "Typing..."
        }
        addToChat(response, Message.SENT_BY_BOT);
    }

    private void callGeminiAPI(String prompt) {
        String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + "AIzaSyDjTv8xQi7kBlLJWnCvFiwfWyeLIOVkSek";
        try {
            JSONObject userPrompt = new JSONObject();
            userPrompt.put("parts", new JSONArray().put(new JSONObject().put("text", prompt)));

            JSONObject requestBodyJson = new JSONObject();
            requestBodyJson.put("contents", new JSONArray().put(userPrompt));

            RequestBody body = RequestBody.create(requestBodyJson.toString(), JSON);
            Request request = new Request.Builder()
                    .url(API_URL)
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(() -> addResponse("Lỗi kết nối: " + e.getMessage()));
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String responseBody = response.body().string();
                    try {
                        JSONObject obj = new JSONObject(responseBody);
                        JSONArray candidates = obj.getJSONArray("candidates");
                        JSONObject content = candidates.getJSONObject(0).getJSONObject("content");
                        JSONArray parts = content.getJSONArray("parts");
                        String reply = parts.getJSONObject(0).getString("text");

                        runOnUiThread(() -> addResponse(reply.trim()));
                    } catch (Exception e) {
                        runOnUiThread(() -> addResponse("Lỗi xử lý phản hồi: " + e.getMessage()));
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}