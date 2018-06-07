package com.example.dicodingvission;

import android.app.Application;

/**
 * Created by aderifaldi on 2018-01-18.
 */

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized MyApplication getInstance() {
        return instance;
    }

}
