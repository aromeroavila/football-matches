package com.arao.footballmatches.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Match implements Parcelable {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("startDate")
    private int startDate;
    @SerializedName("countryId")
    private int countryId;
    @SerializedName("countryName")
    private String countryName;
    @SerializedName("tournamentId")
    private int tournamentId;
    @SerializedName("tournamentName")
    private String tournamentName;
    @SerializedName("tournamentShortName")
    private String tournamentShortName;
    @SerializedName("sportId")
    private int sportId;
    @SerializedName("statusId")
    private int statusId;
    @SerializedName("statusCode")
    private String statusCode;
    @SerializedName("statusDesc")
    private String statusDesc;
    @SerializedName("statusShortDesc")
    private String statusShortDesc;
    @SerializedName("elapsed")
    private int elapsed;
    @SerializedName("elapsedText")
    private String elapsedText;
    @SerializedName("isTicking")
    private boolean isTicking;
    @SerializedName("ballPossession")
    private int ballPossession;
    @SerializedName("outcome")
    private String outcome;
    @SerializedName("predictionOpened")
    private boolean predictionOpened;
    @SerializedName("teams")
    private List<Team> teams = new ArrayList<>();

    public int getBallPossession() {
        return ballPossession;
    }

    public int getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getElapsed() {
        return elapsed;
    }

    public String getElapsedText() {
        return elapsedText;
    }

    public int getId() {
        return id;
    }

    public boolean isTicking() {
        return isTicking;
    }

    public String getName() {
        return name;
    }

    public String getOutcome() {
        return outcome;
    }

    public boolean isPredictionOpened() {
        return predictionOpened;
    }

    public int getSportId() {
        return sportId;
    }

    public int getStartDate() {
        return startDate;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public int getStatusId() {
        return statusId;
    }

    public String getStatusShortDesc() {
        return statusShortDesc;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public Team getHomeTeam() {
        for (Team team : teams) {
            if (team.getNumber() == 1) {
                return team;
            }
        }

        return null;
    }

    public Team getAwayTeam() {
        for (Team team : teams) {
            if (team.getNumber() == 2) {
                return team;
            }
        }

        return null;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getTournamentShortName() {
        return tournamentShortName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.startDate);
        dest.writeInt(this.countryId);
        dest.writeString(this.countryName);
        dest.writeInt(this.tournamentId);
        dest.writeString(this.tournamentName);
        dest.writeString(this.tournamentShortName);
        dest.writeInt(this.sportId);
        dest.writeInt(this.statusId);
        dest.writeString(this.statusCode);
        dest.writeString(this.statusDesc);
        dest.writeString(this.statusShortDesc);
        dest.writeInt(this.elapsed);
        dest.writeString(this.elapsedText);
        dest.writeByte(this.isTicking ? (byte) 1 : (byte) 0);
        dest.writeInt(this.ballPossession);
        dest.writeString(this.outcome);
        dest.writeByte(this.predictionOpened ? (byte) 1 : (byte) 0);
        dest.writeList(this.teams);
    }

    protected Match(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.startDate = in.readInt();
        this.countryId = in.readInt();
        this.countryName = in.readString();
        this.tournamentId = in.readInt();
        this.tournamentName = in.readString();
        this.tournamentShortName = in.readString();
        this.sportId = in.readInt();
        this.statusId = in.readInt();
        this.statusCode = in.readString();
        this.statusDesc = in.readString();
        this.statusShortDesc = in.readString();
        this.elapsed = in.readInt();
        this.elapsedText = in.readString();
        this.isTicking = in.readByte() != 0;
        this.ballPossession = in.readInt();
        this.outcome = in.readString();
        this.predictionOpened = in.readByte() != 0;
        this.teams = new ArrayList<Team>();
        in.readList(this.teams, Team.class.getClassLoader());
    }

    public static final Parcelable.Creator<Match> CREATOR = new Parcelable.Creator<Match>() {
        @Override
        public Match createFromParcel(Parcel source) {
            return new Match(source);
        }

        @Override
        public Match[] newArray(int size) {
            return new Match[size];
        }
    };
}
