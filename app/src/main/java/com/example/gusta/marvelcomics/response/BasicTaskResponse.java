package com.example.gusta.marvelcomics.response;

/**
 * Created by gusta on 06/05/2017.
 */

public class BasicTaskResponse {

    private int statusCode;
    private String body;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
