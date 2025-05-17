package com.example.btl_android_studyapp.model;

public class Todo {
    private long id;
    private String userId;
    private String title;
    private boolean isDone;
    private String dueDate;
    private long noteId;

    public Todo(long id, String userId, String title, boolean isDone, String dueDate, long noteId) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.isDone = isDone;
        this.dueDate = dueDate;
        this.noteId = noteId;
    }

    public Todo(String userId, String title, boolean isDone, String dueDate, long noteId) {
        this.userId = userId;
        this.title = title;
        this.isDone = isDone;
        this.dueDate = dueDate;
        this.noteId = noteId;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public boolean isDone() { return isDone; }
    public void setDone(boolean done) { isDone = done; }
    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
    public long getNoteId() { return noteId; }
    public void setNoteId(long noteId) { this.noteId = noteId; }
}

