package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gusta on 06/05/2017.
 */

public class URL implements Serializable{

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }
}
