package com.arao.footballmatches.data.entity;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("objectCode")
    private String objectCode;
    @SerializedName("objectId")
    private String objectId;
    @SerializedName("title")
    private String title;
    @SerializedName("type")
    private String type;

    public String getObjectCode() {
        return objectCode;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
