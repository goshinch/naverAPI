package com.example.naverapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.naverapi.view.BookActivity;
import com.example.naverapi.view.DicActivity;
import com.example.naverapi.view.NewsActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newsClick(View view) {
        Intent intent = new Intent(getApplicationContext(), NewsActivity.class);
        startActivity(intent);
    }

    public void bookClick(View view) {
        Intent intent = new Intent(getApplicationContext(), BookActivity.class);
        startActivity(intent);
    }

    public void dicClick(View view) {
        Intent intent = new Intent(getApplicationContext(), DicActivity.class);
        startActivity(intent);
    }
}