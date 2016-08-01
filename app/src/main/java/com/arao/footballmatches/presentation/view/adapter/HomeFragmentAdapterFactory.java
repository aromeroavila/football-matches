package com.arao.footballmatches.presentation.view.adapter;

import android.support.v4.app.FragmentManager;

public class HomeFragmentAdapterFactory {

    public HomeFragmentAdapter getHomeFragmentAdapter(FragmentManager fragmentManager) {
        return new HomeFragmentAdapter(fragmentManager);
    }

}
