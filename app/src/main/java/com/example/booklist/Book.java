package com.example.booklist;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.SkipCallbackExecutor;

public class Book  implements Serializable {
    @SerializedName("items")
    @Expose
    private List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }


}
