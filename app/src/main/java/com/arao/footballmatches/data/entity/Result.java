package com.arao.footballmatches.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Result implements Parcelable {

    @SerializedName("runningscore")
    private String runningScore;
    @SerializedName("halftime")
    private String halfTime;

    public String getHalfTime() {
        return halfTime;
    }

    public String getRunningScore() {
        return runningScore;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.runningScore);
        dest.writeString(this.halfTime);
    }

    protected Result(Parcel in) {
        this.runningScore = in.readString();
        this.halfTime = in.readString();
    }

    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
}
