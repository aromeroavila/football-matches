package com.arao.footballmatches.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Match {

    @SerializedName("id")
    public int id;
    @SerializedName("name")
    public String name;
    @SerializedName("startDate")
    public int startDate;
    @SerializedName("countryId")
    public int countryId;
    @SerializedName("countryName")
    public String countryName;
    @SerializedName("tournamentId")
    public int tournamentId;
    @SerializedName("tournamentName")
    public String tournamentName;
    @SerializedName("tournamentShortName")
    public String tournamentShortName;
    @SerializedName("sportId")
    public int sportId;
    @SerializedName("statusId")
    public int statusId;
    @SerializedName("statusCode")
    public String statusCode;
    @SerializedName("statusDesc")
    public String statusDesc;
    @SerializedName("statusShortDesc")
    public String statusShortDesc;
    @SerializedName("elapsed")
    public int elapsed;
    @SerializedName("elapsedText")
    public String elapsedText;
    @SerializedName("isTicking")
    public boolean isTicking;
    @SerializedName("ballPossession")
    public int ballPossession;
    @SerializedName("outcome")
    public String outcome;
    @SerializedName("predictionOpened")
    public boolean predictionOpened;
    @SerializedName("teams")
    public List<Team> teams = new ArrayList<>();

}
