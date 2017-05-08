package com.example.gusta.marvelcomics.model;

import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class Comic implements Serializable {

    @SerializedName("avaible")
    private int avaible;

    @SerializedName("collectionURI")
    private String collectionURI;

    @SerializedName("items")
    private List<ComicItem> items;

    @SerializedName("series")
    private List<ComicItem> series;

    @SerializedName("returned")
    private int returned;

    public void setAvaible(int avaible) {
        this.avaible = avaible;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public void setItems(List<ComicItem> items) {
        this.items = items;
    }

    public void setSeries(List<ComicItem> series) {
        this.series = series;
    }

    public int getAvaible() {
        return avaible;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<ComicItem> getItems() {
        return items;
    }

    public List<ComicItem> getSeries() {
        return series;
    }
}
