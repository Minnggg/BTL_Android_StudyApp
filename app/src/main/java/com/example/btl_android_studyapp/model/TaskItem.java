package com.example.btl_android_studyapp.model;

public class TaskItem {
    private String taskName;
    private boolean isDone;

    public TaskItem(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }
}
