
package com.example.crudapi.UpdatePut.Response;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class

PutResponse {

    @SerializedName("job")
    private String mJob;
    @SerializedName("name")
    private String mName;
    @SerializedName("updatedAt")
    private String mUpdatedAt;

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

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

}
