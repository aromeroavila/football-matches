package com.arao.footballmatches.presentation.view.adapter;

import com.arao.footballmatches.data.entity.Match;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

public class MatchAdapterFactory {

    private final Picasso picasso;

    @Inject
    public MatchAdapterFactory(Picasso picasso) {
        this.picasso = picasso;
    }

    MatchAdapter getMatchAdapter(List<Match> matches) {
        return new MatchAdapter(matches, picasso);
    }

}
