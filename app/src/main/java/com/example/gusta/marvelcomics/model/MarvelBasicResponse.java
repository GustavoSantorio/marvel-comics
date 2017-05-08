package com.example.gusta.marvelcomics.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by gusta on 06/05/2017.
 */

public class MarvelBasicResponse implements Serializable {

    @SerializedName("code")
    private int code;

    @SerializedName("status")
    private String status;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("attributionText")
    private String attributionText;

    @SerializedName("attributionHTML")
    private String attributionHTML;

    @SerializedName("etag")
    private String etag;

    @SerializedName("data")
    private MarvelData data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setData(MarvelData data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public MarvelData getData() {
        return data;
    }
}
