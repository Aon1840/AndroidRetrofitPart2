package com.example.aon_attapon.androidretrofitpart2.manager;

import com.example.aon_attapon.androidretrofitpart2.dao.User;
import com.example.aon_attapon.androidretrofitpart2.manager.http.IUsersApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static IUsersApi service;
    private static HttpManager instance;

    public static HttpManager getInstance(){
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private HttpManager(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(IUsersApi.class);
    }

    public void createUser(User user, Callback<User> callback){
        Call<User> userCall = service.createUser(user);
        userCall.enqueue(callback);
    }
}
