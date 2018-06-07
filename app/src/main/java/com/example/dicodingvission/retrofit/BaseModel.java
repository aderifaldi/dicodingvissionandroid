package com.example.dicodingvission.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by RadyaLabs PC on 28/09/2017.
 */
public class BaseModel {

    @SerializedName("error")
    private boolean error;
    @SerializedName("force")
    private boolean force;
    @SerializedName("alert")
    private Alerts alert;

    public boolean isError() {
        return error;
    }

    public boolean isForce() {
        return force;
    }

    public Alerts getAlert() {
        return alert;
    }

    public static class Alerts {
        @SerializedName("code")
        private int code;
        @SerializedName("message")
        private String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

}
