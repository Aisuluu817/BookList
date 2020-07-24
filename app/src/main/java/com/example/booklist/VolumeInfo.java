package com.example.booklist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VolumeInfo implements Serializable {
    @SerializedName("title")
    private String title;
    @SerializedName("authors")
    private List<String> authors;
    @SerializedName("publishedDate")
    private String publishedDate;
    @SerializedName("pageCount")
    private String pageCount;
    @SerializedName("averageRating")
    private float averageRating;
    @SerializedName("imageLinks")
    private BookImage imageLinks;
    @SerializedName("infoLink")
    private String infoLink;

    public VolumeInfo(String title, String pageCount, String publishedDate,float averageRating, List<String> authors, BookImage imageLinks, String infoLink) {

        this.title = title;
        this.pageCount = pageCount;
        this.publishedDate = publishedDate;
        this.averageRating = averageRating;
        this.authors = authors;
        this.imageLinks = imageLinks;
        this.infoLink = infoLink;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPageCount() {
        return pageCount;
    }

    public void setPageCount(String pageCount) {
        this.pageCount = pageCount;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }

    public BookImage getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(BookImage imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getInfoLink() {
        return infoLink;
    }

    public void setInfoLink(String infoLink) {
        this.infoLink = infoLink;
    }
}

