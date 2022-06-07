
package com.example.crudapi.SingleUsers;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Support {

    @SerializedName("text")
    private String mText;
    @SerializedName("url")
    private String mUrl;

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

}
