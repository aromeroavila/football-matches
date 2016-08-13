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
import com.arao.footballmatches.data.entity.MatchFilter;
import com.arao.footballmatches.injection.components.ActivityComponentProvider;
import com.arao.footballmatches.presentation.presenter.MatchesPresenter;
import com.arao.footballmatches.presentation.view.LeaguesView;
import com.arao.footballmatches.presentation.view.activity.MatchClickListener;
import com.arao.footballmatches.presentation.view.adapter.LeagueAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class LeaguesFragment extends Fragment implements LeaguesView {

    private static final String MATCHES_FILTER_BUNDLE_KEY = "matches_filter_bundle_key";
    private static final String MATCH_BUNDLE_KEY = "match_bundle_key";

    @Inject
    LeagueAdapter leagueAdapter;
    @Inject
    RecyclerView.ItemAnimator itemAnimator;
    @Inject
    RecyclerView.ItemDecoration itemDecoration;
    @Inject
    RecyclerView.LayoutManager layoutManager;
    @Inject
    MatchesPresenter homePresenter;

    @BindView(R.id.loading_layout)
    LinearLayout loadingLayout;
    @BindView(R.id.error_view)
    TextView errorView;
    @BindView(R.id.leagues_recycler)
    RecyclerView leaguesRecyclerView;

    private MatchClickListener matchClickListener;


    public static Fragment newInstance(MatchFilter matchesFilter) {
        LeaguesFragment leaguesFragment = new LeaguesFragment();
        Bundle args = new Bundle();
        args.putSerializable(MATCHES_FILTER_BUNDLE_KEY, matchesFilter);
        leaguesFragment.setArguments(args);
        return leaguesFragment;
    }

    public static Fragment newInstance(Match match) {
        LeaguesFragment leaguesFragment = new LeaguesFragment();
        Bundle args = new Bundle();
        args.putParcelable(MATCH_BUNDLE_KEY, match);
        leaguesFragment.setArguments(args);
        return leaguesFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ((ActivityComponentProvider) getActivity()).getActivityComponent()
                .leaguesFragmentComponent()
                .resolveDependenciesFor(this);

        if (getActivity() instanceof MatchClickListener) {
            matchClickListener = (MatchClickListener) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);
        ButterKnife.bind(this, view);
        loadingLayout.setVisibility(VISIBLE);
        setupRecyclerView();
        initPresenter();
        return view;
    }

    @Override
    public void displayLeagues(List<League> leagues) {
        loadingLayout.setVisibility(GONE);
        errorView.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(VISIBLE);
        leagueAdapter.setData(leagues, matchClickListener);
    }

    @Override
    public void displayError() {
        errorView.setVisibility(VISIBLE);
        loadingLayout.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(GONE);
    }

    private void setupRecyclerView() {
        leaguesRecyclerView.setLayoutManager(layoutManager);
        leaguesRecyclerView.setItemAnimator(itemAnimator);
        leaguesRecyclerView.addItemDecoration(itemDecoration);
        leaguesRecyclerView.setAdapter(leagueAdapter);
    }

    private void initPresenter() {
        MatchFilter filter = (MatchFilter) getArguments().getSerializable(MATCHES_FILTER_BUNDLE_KEY);
        if (filter != null) {
            homePresenter.initWithFilter(this, filter);
        }
        Match match = getArguments().getParcelable(MATCH_BUNDLE_KEY);
        if (match != null) {
            homePresenter.initWithMatch(this, match);
        }
    }

}
