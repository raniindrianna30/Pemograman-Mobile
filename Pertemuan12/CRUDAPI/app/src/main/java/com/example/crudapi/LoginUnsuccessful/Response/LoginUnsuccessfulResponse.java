
package com.example.crudapi.LoginUnsuccessful.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class LoginUnsuccessfulResponse {

    @SerializedName("error")
    private String mError;

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

}
