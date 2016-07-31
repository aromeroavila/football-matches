package com.arao.footballmatches.presentation.view;

import com.arao.footballmatches.data.entity.League;

import java.util.List;

public interface LeaguesView {

    void displayLeagues(List<League> leagues);

    void displayError();

}
