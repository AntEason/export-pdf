package com.example.model;

import java.io.Serializable;

public class Content implements Serializable {

    Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
