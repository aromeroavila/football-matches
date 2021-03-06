package com.arao.footballmatches.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.presentation.view.activity.MatchClickListener;

import java.util.List;

import javax.inject.Inject;

public class LeagueAdapter extends RecyclerView.Adapter<LeagueViewHolder> {

    private final ViewHolderFactory viewHolderFactory;
    private final MatchAdapterFactory matchAdapterFactory;

    private List<League> leagues;
    private MatchClickListener matchClickListener;

    @Inject
    public LeagueAdapter(ViewHolderFactory viewHolderFactory, MatchAdapterFactory matchAdapterFactory) {
        this.viewHolderFactory = viewHolderFactory;
        this.matchAdapterFactory = matchAdapterFactory;
    }

    public void setData(List<League> leagues, MatchClickListener matchClickListener) {
        this.matchClickListener = matchClickListener;
        this.leagues = leagues;
        notifyDataSetChanged();
    }

    @Override
    public LeagueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.leagues_list_item, parent, false);

        MatchAdapter matchAdapter = matchAdapterFactory.getMatchAdapter(matchClickListener);
        LeagueViewHolder leagueViewHolder = viewHolderFactory.createLeagueViewHolder(itemView);
        leagueViewHolder.matchesList.setAdapter(matchAdapter);

        return leagueViewHolder;
    }

    @Override
    public void onBindViewHolder(LeagueViewHolder holder, int position) {
        League league = leagues.get(position);

        String name = league.getName();

        holder.leagueName.setText(name);
        MatchAdapter matchAdapter = (MatchAdapter) holder.matchesList.getAdapter();
        matchAdapter.setData(league.getMatches());
    }

    @Override
    public int getItemCount() {
        int size = 0;
        if (leagues != null) {
            size = leagues.size();
        }
        return size;
    }
}
