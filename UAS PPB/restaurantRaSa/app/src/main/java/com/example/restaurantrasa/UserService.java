package com.example.restaurantrasa;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @POST("register")
    Call<RegisterResponse>registerUsers(@Body RegisterRequest registerRequest);

}
