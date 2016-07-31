package com.arao.footballmatches.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Image implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.objectCode);
        dest.writeString(this.objectId);
        dest.writeString(this.title);
        dest.writeString(this.type);
    }

    protected Image(Parcel in) {
        this.objectCode = in.readString();
        this.objectId = in.readString();
        this.title = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
