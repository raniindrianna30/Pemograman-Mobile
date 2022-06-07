
package com.example.crudapi.Post.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PostResponse {

    @SerializedName("createdAt")
    private String mCreatedAt;
    @SerializedName("id")
    private String mId;
    @SerializedName("job")
    private String mJob;
    @SerializedName("name")
    private String mName;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
