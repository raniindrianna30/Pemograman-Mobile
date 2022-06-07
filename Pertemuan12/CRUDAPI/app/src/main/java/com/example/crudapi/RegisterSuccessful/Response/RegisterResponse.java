
package com.example.crudapi.RegisterSuccessful.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RegisterResponse {

    @SerializedName("id")
    private Long mId;
    @SerializedName("token")
    private String mToken;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
