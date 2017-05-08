package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gusta on 06/05/2017.
 */

public class ComicItem implements Serializable {

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("name")
    private String name;
}
