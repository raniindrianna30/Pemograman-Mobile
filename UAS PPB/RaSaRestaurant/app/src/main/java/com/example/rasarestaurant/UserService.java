package com.example.rasarestaurant;

import com.example.rasarestaurant.Login.LoginRequest;
import com.example.rasarestaurant.Login.LoginResponse;
import com.example.rasarestaurant.Register.RegisterRequest;
import com.example.rasarestaurant.Register.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserService {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("register")
    Call<RegisterResponse>registerUsers(@Body RegisterRequest registerRequest);

    @GET("menu")
    Call<ListMenuResponse> getList();

    @GET("menu/{id}")
    Call<SingleMenuResponse> getOneMenu(@Path("id") String postId);

}
