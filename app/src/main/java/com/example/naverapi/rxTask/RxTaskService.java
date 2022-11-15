package com.example.naverapi.rxTask;

import android.util.Log;
import android.widget.TextView;

import com.example.naverapi.naverAPIkey.NaverKey;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxTaskService implements NaverKey {

    private TextView textView;
    private Disposable background;
    private static RxTaskService instance;

    public static RxTaskService getInstance() {
        if (instance == null)
            instance = new RxTaskService();
        return instance;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public void rxBackground(String string) {
        background = Observable.fromCallable(()-> {
            String apiUrl = "https://openapi.naver.com/v1/search"+string+"&display=10&start=1";
            URL url = new URL(apiUrl);
            Log.d("doInBackground: ", apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("X-Naver-Client-Id", clientId);
            conn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = conn.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            return response.toString();
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( result -> {
                    textView.setText("");
                    JSONArray array = new JSONObject(result).getJSONArray("items");

                    for (int i=0; i<array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);

                        textView.append("title = " + object.optString("title") + "\n");
                        textView.append("link = " + object.optString("link") + "\n");
                        textView.append("description = " + object.optString("description") + "\n");
                        textView.append("postdate = " + object.optString("postdate") + "\n");
                        textView.append("\n");
                    }
                }, Throwable::getMessage);
    }

}