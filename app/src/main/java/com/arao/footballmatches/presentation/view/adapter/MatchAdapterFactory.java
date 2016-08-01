package com.arao.footballmatches.presentation.view.adapter;

import com.arao.footballmatches.presentation.view.activity.MatchClickListener;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class MatchAdapterFactory {

    private final Picasso picasso;

    @Inject
    public MatchAdapterFactory(Picasso picasso) {
        this.picasso = picasso;
    }

    MatchAdapter getMatchAdapter(MatchClickListener matchClickListener) {
        return new MatchAdapter(picasso, matchClickListener);
    }

}
