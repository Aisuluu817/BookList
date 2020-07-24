package com.example.booklist;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GBookApi {
    @GET("volumes?")
    Call<Book> retrieveData(
            @Query("q") String input,
            @Query("maxResults") int maxResults);
}
