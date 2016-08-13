package com.arao.footballmatches.data.entity;

public enum MatchFilter {
    ALL("all"),
    LIVE("live"),
    FINISHED("finished");

    private final String name;

    MatchFilter(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
