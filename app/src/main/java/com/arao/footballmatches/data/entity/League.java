package com.arao.footballmatches.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class League {

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
}
