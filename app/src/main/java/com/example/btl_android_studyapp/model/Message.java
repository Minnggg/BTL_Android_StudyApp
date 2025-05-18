package com.example.btl_android_studyapp.model;

public class Message {
    private String message;
    private String sentBy;

    public static final String SENT_BY_ME = "me";
    public static final String SENT_BY_BOT = "bot";

    public Message(String message, String sentBy) {
        this.message = message;
        this.sentBy = sentBy;
    }

    public String getMessage() {
        return message;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSentBy(String sentBy) {
        this.sentBy = sentBy;
    }
}

