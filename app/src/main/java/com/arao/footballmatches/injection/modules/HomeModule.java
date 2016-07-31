package com.arao.footballmatches.injection.modules;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.presenter.HomePresenter;
import com.arao.footballmatches.presentation.view.adapter.LeagueAdapter;
import com.arao.footballmatches.presentation.view.adapter.LeagueItemDecoration;
import com.arao.footballmatches.presentation.view.adapter.MatchAdapterFactory;
import com.arao.footballmatches.presentation.view.adapter.ViewHolderFactory;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    @Provides
    LeagueAdapter leagueAdapter(ViewHolderFactory viewHolderFactory, MatchAdapterFactory matchAdapterFactory) {
        return new LeagueAdapter(viewHolderFactory, matchAdapterFactory);
    }

    @Provides
    RecyclerView.ItemAnimator itemAnimator() {
        return new DefaultItemAnimator();
    }

    @Provides
    RecyclerView.ItemDecoration itemDecoration(Resources resources) {
        return new LeagueItemDecoration(resources);
    }

    @Provides
    RecyclerView.LayoutManager layoutManager(Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    ViewHolderFactory viewHolderFactory() {
        return new ViewHolderFactory();
    }

    @Provides
    HomePresenter homePresenter(MatchRepository matchRepository) {
        return new HomePresenter(matchRepository);
    }

    @Provides
    MatchAdapterFactory matchAdapterFactory(Picasso picasso) {
        return new MatchAdapterFactory(picasso);
    }

}
