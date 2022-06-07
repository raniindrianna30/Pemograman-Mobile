
package com.example.crudapi.RegisterUnsuccessful.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RegisterUnsuccessfulResponse {

    @SerializedName("error")
    private String mError;

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        mError = error;
    }

}
