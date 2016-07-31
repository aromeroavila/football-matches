package com.arao.footballmatches.presentation.view.adapter;

import com.arao.footballmatches.data.entity.Match;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchAdapterFactory {

    MatchAdapter getMatchAdapter(List<Match> matches, Picasso picasso) {
        return new MatchAdapter(matches, picasso);
    }

}
