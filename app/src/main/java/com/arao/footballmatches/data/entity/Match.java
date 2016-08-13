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
    @SerializedName("tournamentId")
    private int tournamentId;
    @SerializedName("teams")
    private List<Team> teams = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.tournamentId);
        dest.writeList(this.teams);
    }

    protected Match(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.tournamentId = in.readInt();
        this.teams = new ArrayList<>();
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
