package com.example.demo.model.base;


public class Message {
    private String message;
    private String field;

    public Message() {

    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Message(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
