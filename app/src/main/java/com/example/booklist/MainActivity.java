package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText editText;
    private String bookToSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.search);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bookToSearch = editText.getText().toString();

                if (bookToSearch.length() == 0 || bookToSearch.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter the name of the book",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, BookSearchResults.class);
                    intent.putExtra("Search", bookToSearch);
                    Log.e(TAG, "search result: " + bookToSearch);
                    startActivity(intent);
                }
            }
        });
    }
}