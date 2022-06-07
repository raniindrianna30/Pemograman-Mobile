
package com.example.crudapi.SingleUsersResource.Response;

import com.example.crudapi.SingleUsersResource.DataItem.DataItemSingleResource;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class SingleResourceResponse {

    @SerializedName("data")
    private DataItemSingleResource mData;

    public DataItemSingleResource getData() {
        return mData;
    }

    public void setData(DataItemSingleResource data) {
        mData = data;
    }

}
