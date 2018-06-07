package com.example.dicodingvission.view.analyze_photo;

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
import com.example.dicodingvission.view.analyze_photo.model.Actress;
import com.example.dicodingvission.view.analyze_photo.model.Analyze;
import com.example.dicodingvission.view.analyze_photo.model.AutoCaption;
import com.google.gson.JsonObject;

import retrofit2.Call;

public class AnalyzePhotoActivity extends AppCompatActivity {

    private ImageView image;
    private TextView textInfo;
    private SwipeRefreshLayout swipeRefreshLayout;

    private String imageUrl;
    private int vision;

    private ApiRequest apiRequest;
    private ConnectionManager connectionManager;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.analyze_photo_activity);

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
            vision = bundle.getInt("vision");

            Glide.with(this).load(imageUrl).into(image);

            if (vision == Constant.Data.ANALYZE){
                analyze();
            } else if (vision == Constant.Data.AUTO_CAPTION) {
                autoCaption();
            } else { //ACTRESS
                actress();
            }

        }
    }

    private void analyze() {
        swipeRefreshLayout.setRefreshing(true);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", imageUrl);

        String features = "ImageType, Color, Faces, Adult, Categories";

        Call<Analyze> call = apiRequest.call().Analize(features, "en", jsonObject);
        connectionManager.callApi(call, new ConnectionCallback() {
            @Override
            public void onFinishRequest(ApiResponse r) {
                swipeRefreshLayout.setRefreshing(false);

                Analyze response = (Analyze) r.getData();

                if (response != null) {

                    textInfo.append("Image format: " + response.getMetadata().getFormat() + "\n");
                    textInfo.append("Image width: " + response.getMetadata().getWidth() + ", height:"
                            + response.getMetadata().getHeight() + "\n");
                    textInfo.append("Clip Art Type: " + response.getImageType().getClipArtType() + "\n");
                    textInfo.append("Line Drawing Type: " + response.getImageType().getLineDrawingType() + "\n");
                    textInfo.append("Is Adult Content:" + response.getAdult().isIsAdultContent() + "\n");
                    textInfo.append("Adult score:" + response.getAdult().getAdultScore() + "\n");
                    textInfo.append("Is Racy Content:" + response.getAdult().isIsRacyContent() + "\n");
                    textInfo.append("Racy score:" + response.getAdult().getRacyScore() + "\n\n") ;

                    for (Analyze.Categories category: response.getCategories()) {
                        textInfo.append("Category: " + category.getName() + ", score: " + category.getScore() + "\n");
                    }

                    textInfo.append("\n");

                    int faceCount = 0;
                    for (Analyze.Faces face: response.getFaces()) {

                        faceCount++;
                        textInfo.append("face " + faceCount + ", gender:" + face.getGender()
                                + ", age: " + face.getAge() + "\n");
                        textInfo.append("    left: " + face.getFaceRectangle().getLeft()
                                +  ",  top: " + face.getFaceRectangle().getTop()
                                + ", width: " + face.getFaceRectangle().getWidth()
                                + "  height: " + face.getFaceRectangle().getHeight() + "\n" );

                    }

                    if (faceCount == 0) {
                        textInfo.append("No face is detected");
                    }

                    textInfo.append("\n");

                    textInfo.append("\nDominant Color Foreground :" + response.getColor().getDominantColorForeground() + "\n");
                    textInfo.append("Dominant Color Background :" + response.getColor().getDominantColorBackground() + "\n");

                }
            }
        });

    }

    private void autoCaption() {
        swipeRefreshLayout.setRefreshing(true);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", imageUrl);

        String features = "Description";

        Call<AutoCaption> call = apiRequest.call().AutoCaption(features, "en", jsonObject);
        connectionManager.callApi(call, new ConnectionCallback() {
            @Override
            public void onFinishRequest(ApiResponse r) {
                swipeRefreshLayout.setRefreshing(false);

                AutoCaption response = (AutoCaption) r.getData();

                if (response != null) {
                    textInfo.append("Image format: " + response.getMetadata().getFormat() + "\n");
                    textInfo.append("Image width: " + response.getMetadata().getWidth() +
                            ", height: " + response.getMetadata().getHeight());

                    textInfo.append("\n");
                    textInfo.append("\n");

                    for (AutoCaption.Description.Captions caption : response.getDescription().getCaptions()){
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

    private void actress() {
        swipeRefreshLayout.setRefreshing(true);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Url", imageUrl);

        String model = "celebrities";

        Call<Actress> call = apiRequest.call().Actress(model, jsonObject);
        connectionManager.callApi(call, new ConnectionCallback() {
            @Override
            public void onFinishRequest(ApiResponse r) {
                swipeRefreshLayout.setRefreshing(false);

                Actress response = (Actress) r.getData();

                if (response != null) {

                    textInfo.append("Image format: " + response.getMetadata().getFormat() + "\n");
                    textInfo.append("Image width: " + response.getMetadata().getWidth() +
                            ", height:" + response.getMetadata().getHeight() + "\n");
                    textInfo.append("\n");

                    if (response.getResult().getCelebrities().size() != 0){

                        textInfo.append("Celebrities detected: " + response.getResult().getCelebrities().size() + "\n");

                        for (Actress.Result.Celebrities celeb : response.getResult().getCelebrities()){
                            textInfo.append("Name: " + celeb.getName() + ", score: " + celeb.getConfidence() + "\n");
                        }

                    }else {
                        textInfo.append("Celebrities detected: 0");
                    }

                }
            }
        });

    }

}
