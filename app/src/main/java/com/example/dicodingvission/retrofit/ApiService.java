package com.example.dicodingvission.retrofit;

import com.example.dicodingvission.view.analize.AnalizePhoto;
import com.example.dicodingvission.view.land_mark.LandMark;
import com.example.dicodingvission.view.ocr.OCR;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by aderifaldi on 08/08/2016.
 */
public interface ApiService {

    //ANALIZE IMAGE
    @POST("analyze")
    @Headers("Content-Type: application/json")
    Call<AnalizePhoto> AnalizeImage(@Query("visualFeatures") String visualFeatures,
                                    @Query("language") String language,
                                    @Body JsonObject jsonPost);

    //LAND MARK
    @POST("models/landmarks/analyze")
    @Headers("Content-Type: application/json")
    Call<LandMark> LandMark(@Query("model") String model,
                            @Body JsonObject jsonPost);

    //OCR
    @POST("ocr")
    @Headers("Content-Type: application/json")
    Call<OCR> OCR(@Query("language") String language,
                  @Body JsonObject jsonPost);

}
