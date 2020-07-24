package com.example.booklist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Items implements Serializable {
    @SerializedName("volumeInfo")
    private VolumeInfo volumeInfo;

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

}
