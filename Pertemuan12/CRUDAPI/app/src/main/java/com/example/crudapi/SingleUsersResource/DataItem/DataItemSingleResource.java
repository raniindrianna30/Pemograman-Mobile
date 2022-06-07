package com.example.crudapi.SingleUsersResource.DataItem;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DataItemSingleResource {

    @SerializedName("color")
    private String mColor;
    @SerializedName("id")
    private Long mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("pantone_value")
    private String mPantoneValue;
    @SerializedName("year")
    private Long mYear;

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPantoneValue() {
        return mPantoneValue;
    }

    public void setPantoneValue(String pantoneValue) {
        mPantoneValue = pantoneValue;
    }

    public Long getYear() {
        return mYear;
    }

    public void setYear(Long year) {
        mYear = year;
    }

}
