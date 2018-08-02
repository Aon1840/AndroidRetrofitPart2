package com.example.aon_attapon.androidretrofitpart2;

import android.app.Application;

import com.example.aon_attapon.androidretrofitpart2.manager.HttpManager;

public class MainApplication extends Application{
    public static HttpManager instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = HttpManager.getInstance();
    }
}
