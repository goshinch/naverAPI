package com.example.naverapi.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.naverapi.R;
import com.example.naverapi.naverAPIkey.NaverKey;
import com.example.naverapi.retrofit.ListModel;
import com.example.naverapi.retrofit.Model;
import com.example.naverapi.retrofit.NaverService;
import com.example.naverapi.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity implements NaverKey {
    EditText editText;
    TextView textView;
    private static String query = "/news?query=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        editText = findViewById(R.id.edt);
        textView = findViewById(R.id.textView);
    }

    public void newsClick(View view) {
        getApiData(editText.getText().toString());
    }

    private void getApiData(String search) {
        textView.setText("");
        NaverService client = RetrofitClient.getService();
        Call<Model> call = client.getData(clientId,clientSecret,"news", search);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                for (ListModel data : response.body().getItems() ) {
                    textView.append("title = "+ data.getTitle()+"\n");
                    textView.append("link = "+ data.getLink()+"\n");
                    textView.append("description = "+ data.getDesc()+"\n");
                    textView.append("postdate = "+ data.getPostdate()+"\n");
                    textView.append("\n");
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Log.d("onFailure: ", t.getMessage());
            }
        });
    }
}