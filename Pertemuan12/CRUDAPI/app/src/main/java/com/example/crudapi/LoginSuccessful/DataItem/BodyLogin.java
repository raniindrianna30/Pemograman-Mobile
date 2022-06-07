
package com.example.crudapi.LoginSuccessful.DataItem;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BodyLogin {

    @SerializedName("email")
    private String mEmail;
    @SerializedName("password")
    private String mPassword;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

}
