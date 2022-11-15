package com.example.naverapi.AsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.naverapi.naverAPIkey.NaverKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TaskService extends AsyncTask<String, Void, String> implements NaverKey {

    TextView textView;
    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... strings) {
        String result = "";
        try {
            String apiUrl = "https://openapi.naver.com/v1/search"+strings[0]+"&display=10&start=1";
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
            result = response.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d( "doInBackground: ", result);
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        textView.setText("");
        try {
            JSONArray array = new JSONObject(result).getJSONArray("items");

            for (int i=0; i<array.length(); i++) {
                JSONObject object = array.getJSONObject(i);

                textView.append("title = "+ object.optString("title")+"\n");
                textView.append("link = "+ object.optString("link")+"\n");
                textView.append("description = "+ object.optString("description")+"\n");
                textView.append("postdate = "+ object.optString("postdate")+"\n");
                textView.append("\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}