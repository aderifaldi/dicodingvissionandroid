package com.example.dicodingvission.view.analize_photo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dicodingvission.Constant;
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
    private int vission;

    private ApiRequest apiRequest;
    private ConnectionManager connectionManager;

    private Bundle bundle;

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

        swipeRefreshLayout.setEnabled(false);
    }

    private void initRetrofitRequest() {
        apiRequest = new ApiRequest();
        connectionManager = new ConnectionManager();
    }

    private void initData() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            imageUrl = bundle.getString("imageUrl");
            vission = bundle.getInt("vission");

            Glide.with(this).load(imageUrl).into(image);

            if (vission == Constant.Data.ANALIZE){

            } else if (vission == Constant.Data.AUTO_CAPTION) {
                autoCaption();
            } else { //ACTRESS

            }

        }
    }

    private void autoCaption() {
        swipeRefreshLayout.setRefreshing(true);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", imageUrl);

        Call<AnalizePhoto> call = apiRequest.call().AnalizeImage("Description", "en", jsonObject);
        connectionManager.callApi(call, new ConnectionCallback() {
            @Override
            public void onFinishRequest(ApiResponse r) {
                swipeRefreshLayout.setRefreshing(false);
                AnalizePhoto response = (AnalizePhoto) r.getData();
                if (response != null) {
                    textInfo.append("Image format: " + response.getMetadata().getFormat() + "\n");
                    textInfo.append("Image width: " + ("" + response.getMetadata().getWidth()) +
                            ", height: " + ("" + response.getMetadata().getHeight()));

                    textInfo.append("\n");
                    textInfo.append("\n");

                    for (AnalizePhoto.Description.Captions caption : response.getDescription().getCaptions()){
                        textInfo.append("Caption: " + caption.getText() +
                                ", confidence: " + caption.getConfidence());
                    }

                    textInfo.append("\n");
                    textInfo.append("\n");

                    textInfo.append("Tags:");
                    textInfo.append("\n");

                    for (String tag : response.getDescription().getTags()){
                        textInfo.append(tag + "\n");
                    }

                }
            }
        });

    }

}
