package com.example.dicodingvission.view.analize;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dicodingvission.R;
import com.example.dicodingvission.retrofit.ApiRequest;
import com.example.dicodingvission.retrofit.ApiResponse;
import com.example.dicodingvission.retrofit.ConnectionCallback;
import com.example.dicodingvission.retrofit.ConnectionManager;
import com.google.gson.JsonObject;

import retrofit2.Call;

public class AnalizePhotoActivity extends AppCompatActivity {

    private ImageView image;
    private TextView textInfo;
    private SwipeRefreshLayout swipeRefreshLayout;

    private String imageUrl;
    private Intent intent;

    private ApiRequest apiRequest;
    private ConnectionManager connectionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analize_photo_activity);

        initRetrofitRequest();
        initView();
        initData();

    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        image = findViewById(R.id.image);
        textInfo = findViewById(R.id.textInfo);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                analizeImage();
            }
        });
    }

    private void initRetrofitRequest() {
        apiRequest = new ApiRequest();
        connectionManager = new ConnectionManager();
    }

    private void initData() {
        intent = getIntent();
        if (intent != null){
            imageUrl = intent.getStringExtra("imageUrl");
            Glide.with(this).load(imageUrl).into(image);

            analizeImage();

        }
    }

    private void analizeImage() {
        swipeRefreshLayout.setRefreshing(true);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", imageUrl);

        Call<AnalizePhoto> call = apiRequest.call().AnalizeImage("Categories,Description,Color", "en", jsonObject);
        connectionManager.callApi(call, new ConnectionCallback() {
            @Override
            public void onFinishRequest(ApiResponse r) {
                swipeRefreshLayout.setRefreshing(false);
                AnalizePhoto response = (AnalizePhoto) r.getData();
                if (response != null){
                    textInfo.setText(response.getDescription().getCaptions().get(0).getText());
                }
            }
        });

    }

}
