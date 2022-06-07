
package com.example.crudapi.ListUsersResource.Response;

import com.example.crudapi.ListUsersResource.DataItem.DataItemListResource;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class ListUserResourceResponse {

    @SerializedName("data")
    private List<DataItemListResource> mData;
    @SerializedName("page")
    private Long mPage;
    @SerializedName("per_page")
    private Long mPerPage;
    @SerializedName("total")
    private Long mTotal;
    @SerializedName("total_pages")
    private Long mTotalPages;

    public List<DataItemListResource> getData() {
        return mData;
    }

    public void setData(List<DataItemListResource> data) {
        mData = data;
    }

    public Long getPage() {
        return mPage;
    }

    public void setPage(Long page) {
        mPage = page;
    }

    public Long getPerPage() {
        return mPerPage;
    }

    public void setPerPage(Long perPage) {
        mPerPage = perPage;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

    public Long getTotalPages() {
        return mTotalPages;
    }

    public void setTotalPages(Long totalPages) {
        mTotalPages = totalPages;
    }

}
