package com.example.crudapi;

import com.example.crudapi.ListUsers.Response.ListUserResponse;
import com.example.crudapi.ListUsersResource.Response.ListUserResourceResponse;
import com.example.crudapi.LoginSuccessful.DataItem.BodyLogin;
import com.example.crudapi.LoginSuccessful.Response.LoginResponse;
import com.example.crudapi.LoginUnsuccessful.DataItem.BodyLoginUnsuccessful;
import com.example.crudapi.LoginUnsuccessful.Response.LoginUnsuccessfulResponse;
import com.example.crudapi.Post.Response.PostResponse;
import com.example.crudapi.RegisterSuccessful.DataItem.BodyRegister;
import com.example.crudapi.RegisterSuccessful.Response.RegisterResponse;
import com.example.crudapi.RegisterUnsuccessful.DataItem.BodyRegisterUnsuccessful;
import com.example.crudapi.RegisterUnsuccessful.Response.RegisterUnsuccessfulResponse;
import com.example.crudapi.SingleUsers.Response.SingleResponse;
import com.example.crudapi.SingleUsersResource.Response.SingleResourceResponse;
import com.example.crudapi.UpdatePatch.Response.PatchResponse;
import com.example.crudapi.UpdatePut.Response.PutResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface MainInterface {

    // TODO Memasukkan Endpoint
    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("/api/users/2")
    Call<SingleResponse> getSingleUser();

    @GET("/api/users?delay=3")
    Call<ListUserResponse> getDelayed();

    @GET("/api/users/23")
    Call<SingleResponse> getSingleNotFound();

    @GET("/api/unknown/2")
    Call<SingleResourceResponse> getSingleResource();

    @GET("/api/unknown/23")
    Call<SingleResourceResponse> getSingleResourceNotFound();

    @GET("/api/unknown")
    Call<ListUserResourceResponse> getListResource();

    @FormUrlEncoded
    @POST("/api/users")
    Call<PostResponse> createPost(@Field("name") String mName,
                                  @Field("job") String mJob);

    @FormUrlEncoded
    @PUT("/api/users/2")
    Call<PutResponse> updatePut(@Field("name") String mName,
                                @Field("job") String mJob);

    @FormUrlEncoded
    @PATCH("/api/users/2")
    Call<PatchResponse> updatePatch(@Field("name") String mName,
                                    @Field("job") String mJob);

    @DELETE("/api/users/2")
    Call<SingleResponse> deleteList();

    @POST("api/login")
    Call<LoginResponse> postLogin(@Body BodyLogin bodyLogin);

    @POST("api/login")
    Call<LoginUnsuccessfulResponse> postUnsuccessLogin(@Body BodyLoginUnsuccessful bodyLoginUnsuccessful);

    @POST("api/register")
    Call<RegisterResponse> postRegister(@Body BodyRegister bodyRegister);

    @POST("api/register")
    Call<RegisterUnsuccessfulResponse> postRegisterUnsuccessful(@Body BodyRegisterUnsuccessful bodyRegisterUnsuccessful);

}
