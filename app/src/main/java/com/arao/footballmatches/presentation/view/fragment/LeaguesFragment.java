package com.arao.footballmatches.presentation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.presentation.navigation.Navigator;
import com.arao.footballmatches.presentation.view.LeaguesView;
import com.arao.footballmatches.presentation.view.activity.ActivityComponentProvider;
import com.arao.footballmatches.presentation.view.activity.MatchClickListener;
import com.arao.footballmatches.presentation.view.adapter.LeagueAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class LeaguesFragment extends Fragment implements LeaguesView, MatchClickListener {

    @Inject
    LeagueAdapter leagueAdapter;
    @Inject
    RecyclerView.ItemAnimator itemAnimator;
    @Inject
    RecyclerView.ItemDecoration itemDecoration;
    @Inject
    RecyclerView.LayoutManager layoutManager;
    @Inject
    Navigator navigator;

    @BindView(R.id.loading_layout)
    LinearLayout loadingLayout;
    @BindView(R.id.error_view)
    TextView errorView;
    @BindView(R.id.leagues_recycler)
    RecyclerView leaguesRecyclerView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((ActivityComponentProvider) getActivity()).getActivityComponent()
                .leaguesFragmentComponent()
                .resolveDependenciesFor(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);
        ButterKnife.bind(this, view);

        setupRecyclerView();

        return view;
    }

    @Override
    public void displayLeagues(List<League> leagues) {
        loadingLayout.setVisibility(GONE);
        errorView.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(VISIBLE);
        leagueAdapter.setData(leagues, this);
    }

    @Override
    public void displayError() {
        errorView.setVisibility(VISIBLE);
        loadingLayout.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(GONE);
    }

    @Override
    public void onMatchClick(Match match) {
        navigator.navigateToUserDetails(getActivity(), match);
    }

    private void setupRecyclerView() {
        leaguesRecyclerView.setLayoutManager(layoutManager);
        leaguesRecyclerView.setItemAnimator(itemAnimator);
        leaguesRecyclerView.addItemDecoration(itemDecoration);
        leaguesRecyclerView.setAdapter(leagueAdapter);
    }

}
