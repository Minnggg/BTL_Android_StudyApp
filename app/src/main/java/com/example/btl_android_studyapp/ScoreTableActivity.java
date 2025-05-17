package com.example.btl_android_studyapp;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.btl_android_studyapp.adapter.RecycleViewPointAdapter;
import com.example.btl_android_studyapp.api.ApiClient;
import com.example.btl_android_studyapp.databinding.ActivityLogInBinding;
import com.example.btl_android_studyapp.databinding.ActivityScoreTableBinding;
import com.example.btl_android_studyapp.model.DsDiemHocky;
import com.example.btl_android_studyapp.model.DsDiemMonHoc;
import com.example.btl_android_studyapp.model.ScoreResponse;

import java.util.ArrayList;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreTableActivity extends AppCompatActivity {
    ActivityScoreTableBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityScoreTableBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ApiClient.getInstance().getService().getAllPoint(Contanst.userCurrent.getAccess_token()).enqueue(new Callback<ScoreResponse>() {
            @Override
            public void onResponse(Call<ScoreResponse> call, Response<ScoreResponse> response) {
                ArrayList<DsDiemMonHoc> dsDiemMonHocs = new ArrayList<>();
                Optional.ofNullable(response.body().getData()).ifPresent( data -> {
                    binding.GPAScore.setText(data.getDsDiemHocky().get(0).getDtbTichLuyHe4());
                    for(DsDiemHocky hocky : data.getDsDiemHocky()) {
                        Optional.ofNullable(hocky.getDsDiemMonHoc()).ifPresent( v -> {
                            dsDiemMonHocs.addAll(v);
                        });
                    }
                });

                RecycleViewPointAdapter adapter = new RecycleViewPointAdapter(dsDiemMonHocs, ScoreTableActivity.this);
                binding.rvListDiem.setAdapter(adapter);
                binding.rvListDiem.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ScoreResponse> call, Throwable t) {
                System.out.println(t);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }
}