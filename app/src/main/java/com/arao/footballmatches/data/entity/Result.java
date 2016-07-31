package com.arao.footballmatches.data.entity;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("runningscore")
    private String runningScore;
    @SerializedName("halftime")
    private String halfTime;

    public String getHalfTime() {
        return halfTime;
    }

    public String getRunningScore() {
        return runningScore;
    }
}
