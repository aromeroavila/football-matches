package com.arao.footballmatches.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arao.footballmatches.R;
import com.arao.footballmatches.presentation.view.widget.AdapterLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

class LeagueViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.league_title) TextView leagueName;
    @BindView(R.id.matches_list) AdapterLinearLayout matchesList;

    LeagueViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
