package com.example.dicodingvission.retrofit;

import com.example.dicodingvission.view.analyze_photo.model.Analyze;
import com.example.dicodingvission.view.analyze_photo.model.AutoCaption;
import com.example.dicodingvission.view.analyze_photo.model.Actress;
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

    //ANALYZE
    @POST("analyze")
    @Headers("Content-Type: application/json")
    Call<Analyze> Analize(@Query("visualFeatures") String visualFeatures,
                          @Query("language") String language,
                          @Body JsonObject jsonPost);

    //AUTO CAPTION
    @POST("analyze")
    @Headers("Content-Type: application/json")
    Call<AutoCaption> AutoCaption(@Query("visualFeatures") String visualFeatures,
                                  @Query("language") String language,
                                  @Body JsonObject jsonPost);

    //ACTRESS
    @POST("models/celebrities/analyze")
    @Headers("Content-Type: application/json")
    Call<Actress> Actress(@Query("model") String model,
                              @Body JsonObject jsonPost);

}
