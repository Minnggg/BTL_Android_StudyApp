package com.example.btl_android_studyapp.ui.option;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.btl_android_studyapp.ChatbotActivity;
import com.example.btl_android_studyapp.Contanst;
import com.example.btl_android_studyapp.NoteScreen;
import com.example.btl_android_studyapp.PomodoroScreen;
import com.example.btl_android_studyapp.ScoreTableActivity;
import com.example.btl_android_studyapp.ToDoScreen;
import com.example.btl_android_studyapp.databinding.FragmentNotificationsBinding;

public class OptionFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvNameStudent.setText(Contanst.userCurrent.getName() + "\n" + Contanst.userCurrent.getUserName());
        binding.btnGoToScoreTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ScoreTableActivity.class));
            }
        });

        binding.btnGoToScreenToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ToDoScreen.class));
            }
        });

        binding.btnGoToNoteScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NoteScreen.class));
            }
        });

        binding.btnGoToChatBotScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ChatbotActivity.class));
            }
        });

        binding.btnGoToPomodoroScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PomodoroScreen.class));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}