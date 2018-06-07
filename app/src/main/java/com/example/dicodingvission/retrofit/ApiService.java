package com.example.dicodingvission.retrofit;

import com.example.dicodingvission.view.analize_photo.AnalizePhoto;
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

}
