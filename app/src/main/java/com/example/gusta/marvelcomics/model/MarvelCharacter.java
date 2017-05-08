package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class MarvelCharacter implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("modified")
    private String modified;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("comics")
    private Comic comics;

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("urls")
    private List<URL> urls;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setComics(Comic comics) {
        this.comics = comics;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public Comic getComics() {
        return comics;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public List<URL> getUrls() {
        return urls;
    }
}
