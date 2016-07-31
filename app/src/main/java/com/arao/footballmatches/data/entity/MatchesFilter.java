package com.arao.footballmatches.data.entity;

public enum MatchesFilter {
    ALL("all"),
    LIVE("live"),
    FINISHED("finished");

    private final String name;

    MatchesFilter(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
