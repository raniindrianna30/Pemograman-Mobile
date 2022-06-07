
package com.example.crudapi.LoginUnsuccessful.DataItem;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BodyLoginUnsuccessful {

    @SerializedName("email")
    private String mEmail;

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

}
