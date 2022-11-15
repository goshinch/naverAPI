package com.example.naverapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naverapi.AsyncTask.TaskService;
import com.example.naverapi.R;

public class BookActivity extends AppCompatActivity {
    private static String query = "/book?query=";
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        editText = findViewById(R.id.edt);
        textView = findViewById(R.id.textView);
    }

    public void bookClick(View view) {
        TaskService taskService = new TaskService();
        taskService.setTextView(textView);
        taskService.execute(query + editText.getText().toString());
    }
}