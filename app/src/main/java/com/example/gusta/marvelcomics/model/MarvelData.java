package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class MarvelData {

    @SerializedName("offset")
    private int offset;

    @SerializedName("limit")
    private int limit;

    @SerializedName("total")
    private int total;

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private List<MarvelCharacter> results;

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setResults(List<MarvelCharacter> results) {
        this.results = results;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    public List<MarvelCharacter> getResults() {
        return results;
    }
}
