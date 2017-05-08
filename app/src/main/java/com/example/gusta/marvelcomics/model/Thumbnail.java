package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gusta on 06/05/2017.
 */

public class Thumbnail implements Serializable{

    @SerializedName("path")
    private String path;

    @SerializedName("extension")
    private String extension;

    public void setPath(String path) {
        this.path = path;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
