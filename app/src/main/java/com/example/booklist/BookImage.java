package com.example.booklist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BookImage implements Serializable {
    @SerializedName("smallThumbnail")
    private String smallThumbnail;
    @SerializedName("thumbnail")
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

