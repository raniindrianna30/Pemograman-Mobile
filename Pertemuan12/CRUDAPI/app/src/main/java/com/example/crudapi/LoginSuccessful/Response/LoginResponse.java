
package com.example.crudapi.LoginSuccessful.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LoginResponse {

    @SerializedName("token")
    private String mToken;

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
