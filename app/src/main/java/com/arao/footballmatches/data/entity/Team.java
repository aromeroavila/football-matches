package com.arao.footballmatches.data.entity;

import com.google.gson.annotations.SerializedName;

public class Team {

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
}
