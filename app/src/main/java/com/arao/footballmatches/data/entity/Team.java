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
    @SerializedName("shortName")
    private String shortName;
    @SerializedName("redCardsTotal")
    private int redCardsTotal;
    @SerializedName("results")
    private Result results;
    @SerializedName("outcome")
    private String outcome;
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

    public int getNumber() {
        return number;
    }

    public String getOutcome() {
        return outcome;
    }

    public int getRedCardsTotal() {
        return redCardsTotal;
    }

    public Result getResults() {
        return results;
    }

    public String getShortName() {
        return shortName;
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
        dest.writeString(this.shortName);
        dest.writeInt(this.redCardsTotal);
        dest.writeParcelable(this.results, flags);
        dest.writeString(this.outcome);
        dest.writeString(this.logoUrl);
    }

    protected Team(Parcel in) {
        this.id = in.readInt();
        this.number = in.readInt();
        this.name = in.readString();
        this.shortName = in.readString();
        this.redCardsTotal = in.readInt();
        this.results = in.readParcelable(Result.class.getClassLoader());
        this.outcome = in.readString();
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
