package com.arao.footballmatches.presentation.view.adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.matches_list_item, viewGroup, false);
            viewHolder = setupViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final Match match = matches.get(i);
        fillViewHolderData(viewHolder, match);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (matchClickListener != null) {
                    matchClickListener.onMatchClick(match);
                }
            }
        });

        return view;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    private ViewHolder setupViewHolder(View view) {
        ViewHolder viewHolder;
        viewHolder = new ViewHolder();
        viewHolder.team1Logo = (ImageView) view.findViewById(R.id.team1_logo);
        viewHolder.team1Name = (TextView) view.findViewById(R.id.team1_name);
        viewHolder.team1Score = (TextView) view.findViewById(R.id.team1_score);
        viewHolder.team2Logo = (ImageView) view.findViewById(R.id.team2_logo);
        viewHolder.team2Name = (TextView) view.findViewById(R.id.team2_name);
        viewHolder.team2Score = (TextView) view.findViewById(R.id.team2_score);
        return viewHolder;
    }

    private void fillViewHolderData(ViewHolder viewHolder, Match match) {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        Result homeTeamResults = homeTeam.getResults();
        String homeTeamScore = homeTeamResults != null ? homeTeamResults.getRunningScore() : " ";
        Result awayTeamResults = homeTeam.getResults();
        String awayTeamScore = awayTeamResults != null ? awayTeamResults.getRunningScore() : " ";

        picasso.load(homeTeam.getLogoUrl()).into(viewHolder.team1Logo);
        viewHolder.team1Name.setText(homeTeam.getName());
        viewHolder.team1Score.setText(homeTeamScore);
        picasso.load(awayTeam.getLogoUrl()).into(viewHolder.team2Logo);
        viewHolder.team2Name.setText(awayTeam.getName());
        viewHolder.team2Score.setText(awayTeamScore);
    }

    private class ViewHolder {
        ImageView team1Logo;
        TextView team1Name;
        TextView team1Score;
        ImageView team2Logo;
        TextView team2Name;
        TextView team2Score;
    }
}
