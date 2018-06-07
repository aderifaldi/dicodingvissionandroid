package com.example.dicodingvission.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aderifaldi on 16/01/2017.
 */
public class ApiResponse<T> {

    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
