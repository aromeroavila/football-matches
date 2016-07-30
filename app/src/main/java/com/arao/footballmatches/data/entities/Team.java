package com.arao.footballmatches.data.entities;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("id")
    public int id;
    @SerializedName("number")
    public int number;
    @SerializedName("name")
    public String name;
    @SerializedName("shortName")
    public String shortName;
    @SerializedName("redCardsTotal")
    public int redCardsTotal;
    @SerializedName("results")
    public String results;
    @SerializedName("outcome")
    public String outcome;
    @SerializedName("logoUrl")
    public String logoUrl;

}
