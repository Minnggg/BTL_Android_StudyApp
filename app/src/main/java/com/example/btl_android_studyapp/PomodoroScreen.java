package com.example.btl_android_studyapp;

import android.app.AlertDialog;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_android_studyapp.adapter.SpinnerTaskAdapter;
import com.example.btl_android_studyapp.databinding.ActivityPomodoroScreenBinding;
import com.example.btl_android_studyapp.model.TaskItem;

import java.util.ArrayList;

public class PomodoroScreen extends AppCompatActivity {
    ActivityPomodoroScreenBinding binding;
    private CountDownTimer countdownTimer;
    private final long learnTime = 1500000;
    private long breakTime = 300000;
    private long timeLeftInMillis = learnTime;
    private long totalTime = learnTime;
    private boolean isLearn = true;
    private boolean isClockRunning = false;
    private MediaPlayer mediaPlayer;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityPomodoroScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.timerCircularProgressBar.setProgressMax(100f);

        binding.controlClockBtn.setOnClickListener(v -> clockControl());

        binding.nextClockBtn.setOnClickListener(v -> nextClockStatus());

        binding.refreshClockBtn.setOnClickListener(v -> refreshClock());

        updateCountdownText();
        updateTimerProgressBar(totalTime);

        ArrayList<TaskItem> taskList = new ArrayList<>();
        SpinnerTaskAdapter spinnerTaskAdapter = new SpinnerTaskAdapter(PomodoroScreen.this, taskList);

        binding.spinnerTask.setAdapter(spinnerTaskAdapter);

        binding.addTaskBtn.setOnClickListener(v -> {
            String taskName = binding.addTaskEditText.getText().toString();
            addTask(spinnerTaskAdapter, taskName);
            binding.addTaskEditText.setText("");
        });

        binding.deleteTaskBtn.setOnClickListener(v -> {
            int position = binding.spinnerTask.getSelectedItemPosition();
            deleteTask(spinnerTaskAdapter, position);
        });

        binding.checkTaskBtn.setOnClickListener(v -> {
            int position = binding.spinnerTask.getSelectedItemPosition();
            checkTask(spinnerTaskAdapter, position);
        });

        binding.clearTaskBtn.setOnClickListener(v -> {
            clearTask(spinnerTaskAdapter);
            binding.addTaskEditText.setText("");
        });

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addTask(SpinnerTaskAdapter adapter, String taskName) {
        Log.e("Pomodoro", "Added task");
        adapter.add(taskName);
    }

    private void deleteTask(SpinnerTaskAdapter adapter, int position) {
        Log.e("Pomodoro", "Deleted task");
        adapter.delete(position);
    }

    private void checkTask(SpinnerTaskAdapter adapter, int position) {
        Log.e("Pomodoro", "Checked task");
        adapter.check(position);
    }

    private void clearTask(SpinnerTaskAdapter adapter) {
        Log.e("Pomodoro", "Cleared task list");
        adapter.clear();
    }

    private void clockControl() {
        if (binding.controlClockBtn.getPaddingLeft() != 0) {
            binding.controlClockBtn.setImageResource(R.drawable.pause_btn_img);
            binding.controlClockBtn.setPadding(0, 0, 0, 0);
            startCountdown();
        } else {
            binding.controlClockBtn.setImageResource(R.drawable.resume_btn_img);
            binding.controlClockBtn.setPadding(17, 0, 0, 0);
            countdownTimer.cancel();
        }
    }

    private void updateCountdownText() {
        long minutes = timeLeftInMillis / 1000 / 60;
        long seconds = timeLeftInMillis / 1000 % 60;

        String formatted = String.format("%02d:%02d", minutes, seconds);
        binding.clockTextview.setText(formatted);
    }

    private void startCountdown() {
        countdownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isClockRunning = true;
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
                updateTimerProgressBar(totalTime);
            }

            @Override
            public void onFinish() {
                isClockRunning = false;
                timeLeftInMillis = 0;
                updateCountdownText();
                binding.controlClockBtn.setImageResource(R.drawable.resume_btn_img);
                binding.controlClockBtn.setPadding(17, 0, 0, 0);
                showEndTimeDialog();
                setClockTime();
                setNoticeText();
                updateTimerProgressBar(totalTime);
                setLearnStatus();
                new Handler().postDelayed(() -> updateCountdownText(), 1000);
                playAlarm();
                vibrateDevice();
            }
        }.start();
    }

    private void updateTimerProgressBar(long time) {
        float percent = ((float) (time - timeLeftInMillis) / time) * 100;
        long duration = time / 10;
        binding.timerCircularProgressBar.setProgressWithAnimation(percent * 1.25f, duration);
    }

    private void setClockTime() {
        if (isLearn) {
            totalTime = breakTime;
            timeLeftInMillis = breakTime;
        } else {
            totalTime = learnTime;
            timeLeftInMillis = learnTime;
        }
    }

    private void setNoticeText() {
        binding.noticeTextView.setText(isLearn ? "Take a break for 5 minutes" : "Stay focus for 25 minutes");
    }

    private void setLearnStatus() {
        isLearn = !isLearn;
    }

    private void nextClockStatus() {
        binding.controlClockBtn.setImageResource(R.drawable.resume_btn_img);
        binding.controlClockBtn.setPadding(17, 0, 0, 0);
        if (isClockRunning) countdownTimer.cancel();
        setClockTime();
        setNoticeText();
        updateTimerProgressBar(totalTime);
        updateCountdownText();
        setLearnStatus();
    }

    private void refreshClock() {
        isLearn = true;
        totalTime = learnTime;
        timeLeftInMillis = learnTime;
        binding.noticeTextView.setText("Stay focus for 25 minutes");
        binding.controlClockBtn.setImageResource(R.drawable.resume_btn_img);
        binding.controlClockBtn.setPadding(17, 0, 0, 0);
        if (isClockRunning) countdownTimer.cancel();
        updateCountdownText();
        updateTimerProgressBar(totalTime);
    }

    private void showEndTimeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(PomodoroScreen.this);
        String message = isLearn ? "Hãy nghỉ ngơi trong 5 phút bạn nhé!" : "Hãy tập trung làm việc trong 25 phút bạn nhé!";
        builder.setMessage(message);
        builder.setCancelable(false);
        builder.setPositiveButton("OK, let's go!", (dialog, which) -> {
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                    if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.stop();
                }
        );
        builder.create().show();
    }

    private void playAlarm() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.alarm);
        mediaPlayer.start();
    }

    private void vibrateDevice() {
        if (vibrator == null) {
            vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        }

        if (vibrator != null && vibrator.hasVibrator()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                VibrationEffect effect = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
                vibrator.vibrate(effect);
            } else {
                vibrator.vibrate(1000); // Rung 1 giây
            }
        } else {
            Log.e("Pomodoro", "Thiết bị không hỗ trợ rung hoặc chưa khởi tạo vibrator.");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}