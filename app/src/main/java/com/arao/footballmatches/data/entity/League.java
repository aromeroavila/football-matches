package com.arao.footballmatches.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class League implements Parcelable {

    @SerializedName("name")
    private String name;
    @SerializedName("additionalName")
    private String additionalName;
    @SerializedName("image")
    private Image image;
    @SerializedName("relatedToObjectCode")
    private String relatedToObjectCode;
    @SerializedName("relatedToObjectId")
    private String relatedToObjectId;
    @SerializedName("hasStandings")
    private boolean hasStandings;
    @SerializedName("matches")
    private List<Match> matches = new ArrayList<>();

    public String getAdditionalName() {
        return additionalName;
    }

    public boolean isHasStandings() {
        return hasStandings;
    }

    public Image getImage() {
        return image;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public String getName() {
        return name;
    }

    public String getRelatedToObjectCode() {
        return relatedToObjectCode;
    }

    public String getRelatedToObjectId() {
        return relatedToObjectId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.additionalName);
        dest.writeParcelable(this.image, flags);
        dest.writeString(this.relatedToObjectCode);
        dest.writeString(this.relatedToObjectId);
        dest.writeByte(this.hasStandings ? (byte) 1 : (byte) 0);
        dest.writeTypedList(this.matches);
    }

    protected League(Parcel in) {
        this.name = in.readString();
        this.additionalName = in.readString();
        this.image = in.readParcelable(Image.class.getClassLoader());
        this.relatedToObjectCode = in.readString();
        this.relatedToObjectId = in.readString();
        this.hasStandings = in.readByte() != 0;
        this.matches = in.createTypedArrayList(Match.CREATOR);
    }

    public static final Parcelable.Creator<League> CREATOR = new Parcelable.Creator<League>() {
        @Override
        public League createFromParcel(Parcel source) {
            return new League(source);
        }

        @Override
        public League[] newArray(int size) {
            return new League[size];
        }
    };
}
