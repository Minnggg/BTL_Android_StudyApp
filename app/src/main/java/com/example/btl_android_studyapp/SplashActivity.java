package com.example.btl_android_studyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        Context context = getApplicationContext();
        SharedPreferences sharedPref = context.getSharedPreferences("BTLAndroid", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        boolean daVao = sharedPref.getBoolean("DaVao", false);

        if (daVao) {
            new Handler().postDelayed(() -> {
                editor.putBoolean("DaVao", true);
                editor.apply();
                startActivity(new Intent(SplashActivity.this, LogInActivity.class));
                finish();
            }, 1500); // 1.5 giây
        } else {
            new Handler().postDelayed(() -> {
                editor.putBoolean("DaVao", true);
                editor.apply();
                startActivity(new Intent(SplashActivity.this, LetStartActivity.class));
                finish();
            }, 1500); // 1.5 giây
        }
    }
}