package com.arao.footballmatches.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Team implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("number")
    private int number;
    @SerializedName("name")
    private String name;
    @SerializedName("results")
    private Result results;
    @SerializedName("logoUrl")
    private String logoUrl;

    public int getId() {
        return id;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public String getName() {
        return name;
    }

    int getNumber() {
        return number;
    }

    public Result getResults() {
        return results;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.number);
        dest.writeString(this.name);
        dest.writeParcelable(this.results, flags);
        dest.writeString(this.logoUrl);
    }

    protected Team(Parcel in) {
        this.id = in.readInt();
        this.number = in.readInt();
        this.name = in.readString();
        this.results = in.readParcelable(Result.class.getClassLoader());
        this.logoUrl = in.readString();
    }

    public static final Parcelable.Creator<Team> CREATOR = new Parcelable.Creator<Team>() {
        @Override
        public Team createFromParcel(Parcel source) {
            return new Team(source);
        }

        @Override
        public Team[] newArray(int size) {
            return new Team[size];
        }
    };
}
