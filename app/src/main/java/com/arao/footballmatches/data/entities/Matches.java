package com.arao.footballmatches.data.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Matches {

    @SerializedName("name")
    public String name;
    @SerializedName("additionalName")
    public String additionalName;
    @SerializedName("image")
    public Image image;
    @SerializedName("relatedToObjectCode")
    public String relatedToObjectCode;
    @SerializedName("relatedToObjectId")
    public String relatedToObjectId;
    @SerializedName("hasStandings")
    public boolean hasStandings;
    @SerializedName("matches")
    public List<Match> matches = new ArrayList<>();

}
