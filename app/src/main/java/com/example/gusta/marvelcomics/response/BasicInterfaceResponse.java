package com.example.gusta.marvelcomics.response;

/**
 * Created by gusta on 06/05/2017.
 */

public class BasicInterfaceResponse {

    private int statusCode;
    private String message;
    private Object object;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
