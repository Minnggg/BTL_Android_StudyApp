package com.example.btl_android_studyapp.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.example.btl_android_studyapp.R;
import com.example.btl_android_studyapp.model.TaskItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SpinnerTaskAdapter extends ArrayAdapter<TaskItem> {

    private static final String TAG = "SpinnerTaskAdapter";
    private final Activity activity;
    private final ArrayList<TaskItem> taskList;

    public SpinnerTaskAdapter(Activity activity, ArrayList<TaskItem> taskList) {
        super(activity, R.layout.spinner_task_item, taskList);
        this.activity = activity;
        this.taskList = taskList;
    }

    public void add(String taskName) {
        if (!taskName.isEmpty()) {
            taskList.add(new TaskItem(taskName));
            notifyDataSetChanged();
            Log.e(TAG, "added");
        }
    }

    public void delete(int position) {
        if (!taskList.isEmpty() && position >= 0 && position < taskList.size()) {
            taskList.remove(position);
            notifyDataSetChanged();
            Log.e(TAG, "deleted");
        }
    }

    public void check(int position) {
        if (!taskList.isEmpty() && position >= 0 && position < taskList.size()) {
            taskList.get(position).setIsDone(true);
            notifyDataSetChanged();
            Log.e(TAG, "done");
        }
    }

    @Override
    public void clear() {
        taskList.clear();
        notifyDataSetChanged();
    }

    private int getDoneTaskCount() {
        int cnt = 0;
        for (TaskItem item : taskList) {
            if (item.getIsDone()) {
                cnt++;
            }
        }
        return cnt;
    }

    private void sortTaskList() {
        Collections.sort(taskList, Comparator.comparing(TaskItem::getIsDone));
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(activity).inflate(R.layout.spinner_task_item, parent, false);

        TextView taskName = view.findViewById(R.id.taskName);
        TextView taskIndex = view.findViewById(R.id.taskIndex);
        CardView cardViewTaskItem = view.findViewById(R.id.cardViewTaskItem);

        TaskItem task = taskList.get(position);
        taskName.setText(task.getTaskName());
        taskIndex.setText(getDoneTaskCount() + "/" + taskList.size());

        if (task.getIsDone()) {
            cardViewTaskItem.setCardBackgroundColor(android.graphics.Color.parseColor("#92f0c1"));
        }

        return view;
    }
}