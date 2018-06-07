package com.example.dicodingvission.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.dicodingvission.Constant;
import com.example.dicodingvission.util.ToastUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConnectionManager<T> {
    private final String TAG = "CONNECTION_MANAGER";

    private ApiResponse<T> apiResponse;

    private String alertMessage;

    private int responseCode;

    public ConnectionManager() {
    }

    public void callApi(final Call<T> call, final ConnectionCallback callback) {

        apiResponse = new ApiResponse<>();

        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

                responseCode = response.code();
                Log.d(TAG, "Response code : " + responseCode);

                alertMessage = response.message();

                if (response.isSuccessful()) {
                    try {
                        if (responseCode == 200) {

                            apiResponse.setData(response.body());

                        } else {

                            showToast(alertMessage);

                        }
                    } catch (Exception e) {
                        e.printStackTrace();

                        showToast(e.getMessage());
                        apiResponse.setData(null);
                    }

                } else {

                    if (response.errorBody() != null) {
                        try {
                            if (!"".equals(response.errorBody().string())) {

                                alertMessage = response.errorBody().string();

                            }
                        } catch (IOException e) {

                            e.printStackTrace();

                        }
                    }

                    showToast(alertMessage);
                    apiResponse.setData(null);
                }

                callback.onFinishRequest(apiResponse);

            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {

                if (t instanceof IOException) {
                    alertMessage = "Connection problem";
                } else {
                    alertMessage = t.getMessage();
                }

                showToast(alertMessage);
                apiResponse.setData(null);
                callback.onFinishRequest(apiResponse);

            }
        });
    }

    private void showToast(String alertMessage) {
        ToastUtils.showToast(alertMessage);
    }

}
