package com.example.dicodingvission.retrofit;

import com.example.dicodingvission.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by RadyaLabs PC on 08/02/2018.
 */

public class ApiRequest {

    private String baseUrl = Constant.Api.BASE_URL;

    public ApiRequest(){
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public ApiService call() {

        Gson gson = new GsonBuilder()
                .setDateFormat(Constant.DateFormat.SERVER)
                .create();

        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.readTimeout(Constant.Api.TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(Constant.Api.TIMEOUT, TimeUnit.SECONDS);
        builder.addInterceptor(logInterceptor);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .header(Constant.Api.Params.KEY, Constant.SUBSCRIPTION_KEY);
                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        return retrofit.create(ApiService.class);
    }

}
