package com.example.booklist;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookSearchResults extends AppCompatActivity  {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Items> myList = new ArrayList<>();
    private String result;
    private ProgressBar progressBar;
    private TextView emptyState;
    private BookListAdapter adapter;
    private TextView textView;

    private static final String BASE_URL = "https://www.googleapis.com/books/v1/";
    private static final String TAG = BookSearchResults.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        emptyState = findViewById(R.id.empty_list);
        textView = findViewById(R.id.text_view);
        textView.setVisibility(View.GONE);
        progressBar = (ProgressBar) findViewById(R.id.loading_spinner);

        checkConnection();
    }



    private void checkConnection() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()){
            textView.setVisibility(View.VISIBLE);
            retrofitInstance();
        }
        else{
            progressBar.setVisibility(View.GONE);
            emptyState.setText("No internet connection");
        }
    }

    private void retrofitInstance() {
        result = getIntent().getExtras().getString("Search").trim().replace(" ", "+");
        int maxResults = 10;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GBookApi request = retrofit.create(GBookApi.class);


        Call<Book> call = request.retrieveData(result, maxResults);

        call.enqueue(new Callback<Book>() {

            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Log.e(TAG, "Status Code = " + response.code());

                myList = response.body().getItems();


                if (myList != null) {
                    setAdapter();
                    progressBar.setVisibility(View.GONE);

                    for (int i = 0; i < myList.size(); i++) {
                        adapter.addAll(myList);

                    }
                } else {
                    adapter.clear();
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                Log.e(TAG, "FAIL: " + t.getMessage());
                Log.e(TAG, "failed at : " + call.request().url());
            }
        });
    }

    private void setAdapter() {
            adapter = new BookListAdapter(myList, getApplicationContext());
            layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);

        }

}
