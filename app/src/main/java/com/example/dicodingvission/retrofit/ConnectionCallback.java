package com.example.dicodingvission.retrofit;

/**
 * Created by aderifaldi on 08/08/2016.
 */
public interface ConnectionCallback<T> {

    void onFinishRequest(ApiResponse<T> r);

}
