
package com.example.crudapi.RegisterUnsuccessful.DataItem;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BodyRegisterUnsuccessful {

    @SerializedName("email")
    private String mEmail;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

}
