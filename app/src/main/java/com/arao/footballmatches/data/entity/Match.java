package com.arao.footballmatches.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Match {

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
}
