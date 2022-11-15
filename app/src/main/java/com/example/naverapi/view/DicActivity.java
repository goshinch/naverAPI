package com.example.naverapi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naverapi.R;
import com.example.naverapi.rxTask.RxTaskService;

public class DicActivity extends AppCompatActivity {
    private static String query = "/encyc?query=";
    EditText editText;
    TextView textView;
    RxTaskService rxTaskService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dic);
        editText = findViewById(R.id.edt);
        textView = findViewById(R.id.textView);
    }

    public void dicClick(View view) {
        rxTaskService = RxTaskService.getInstance();
        rxTaskService.setTextView(textView);
        rxTaskService.rxBackground(query + editText.getText().toString());
    }
}