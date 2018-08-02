package com.example.aon_attapon.androidretrofitpart2.manager.http;

import com.example.aon_attapon.androidretrofitpart2.dao.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IUsersApi {

    @POST("/users")
    Call<User> createUser(@Body User user);
}
