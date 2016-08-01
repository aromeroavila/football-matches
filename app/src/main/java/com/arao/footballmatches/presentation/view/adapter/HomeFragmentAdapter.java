package com.arao.footballmatches.presentation.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.arao.footballmatches.data.entity.MatchesFilter;
import com.arao.footballmatches.presentation.view.fragment.LeaguesFragment;

import static com.arao.footballmatches.data.entity.MatchesFilter.ALL;
import static com.arao.footballmatches.data.entity.MatchesFilter.FINISHED;
import static com.arao.footballmatches.data.entity.MatchesFilter.LIVE;

public class HomeFragmentAdapter extends FragmentPagerAdapter {

    private static final int NUM_ITEMS = 3;
    private static final MatchesFilter FILTERS[] = new MatchesFilter[]{ALL, LIVE, FINISHED};

    HomeFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return LeaguesFragment.newInstance(FILTERS[position]);
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return FILTERS[position].toString();
    }

}
