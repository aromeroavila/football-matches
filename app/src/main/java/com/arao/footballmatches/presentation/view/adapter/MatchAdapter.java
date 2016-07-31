package com.arao.footballmatches.presentation.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.data.entity.Result;
import com.arao.footballmatches.data.entity.Team;
import com.arao.footballmatches.presentation.view.activity.MatchClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

class MatchAdapter extends BaseAdapter {

    private final Picasso picasso;
    private final List<Match> matches;
    private final MatchClickListener matchClickListener;

    MatchAdapter(List<Match> matches, Picasso picasso, MatchClickListener listener) {
        this.matches = matches;
        this.picasso = picasso;
        this.matchClickListener = listener;
    }

    @Override
    public int getCount() {
        int size = 0;
        if (matches != null) {
            size = matches.size();
        }
        return size;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.matches_list_item, viewGroup, false);

        // TODO: extract to View Holder
        final Match match = matches.get(i);
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        Result homeTeamResults = homeTeam.getResults();
        String homeTeamScore = homeTeamResults != null ? homeTeamResults.getRunningScore() : "*";
        Result awayTeamResults = homeTeam.getResults();
        String awayTeamScore = awayTeamResults != null ? awayTeamResults.getRunningScore() : "*";

        ((TextView) itemView.findViewById(R.id.team1_name)).setText(homeTeam.getName());
        ((TextView) itemView.findViewById(R.id.team1_score)).setText(homeTeamScore);
        ImageView homeTeamLogo = (ImageView) itemView.findViewById(R.id.team1_logo);
        ((TextView) itemView.findViewById(R.id.team2_name)).setText(awayTeam.getName());
        ((TextView) itemView.findViewById(R.id.team2_score)).setText(awayTeamScore);
        ImageView awayTeamLogo = (ImageView) itemView.findViewById(R.id.team2_logo);
        picasso.load(homeTeam.getLogoUrl()).into(homeTeamLogo);
        picasso.load(awayTeam.getLogoUrl()).into(awayTeamLogo);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matchClickListener.onMatchClick(match);
            }
        });

        itemView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return itemView;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
