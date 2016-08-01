package com.arao.footballmatches.presentation.view.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

/**
 * A linear layout that will contain views taken from an adapter. It differs from the list view in
 * the fact that it will not optimize anything and draw all the views from the adapter.
 * It also does not provide scrolling.
 * <p>
 * Extracted from: http://stackoverflow.com/a/24905387
 */
public class AdapterLinearLayout extends LinearLayout {

    private Adapter mAdapter;
    private DataSetObserver mDataSetObserver = new DataSetObserver() {
        @Override
        public void onChanged() {
            super.onChanged();
            reloadChildViews();
        }
    };

    public AdapterLinearLayout(Context context) {
        super(context);
    }

    public AdapterLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Adapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(Adapter adapter) {
        if (adapter != null) {
            mAdapter = adapter;
            mAdapter.registerDataSetObserver(mDataSetObserver);
        }

        reloadChildViews();
    }

    private void reloadChildViews() {
        removeAllViews();

        if (mAdapter == null) {
            return;
        }

        int count = mAdapter.getCount();
        for (int position = 0; position < count; position++) {
            View v = mAdapter.getView(position, null, this);
            if (v != null) {
                addView(v);
            }
        }

        requestLayout();
    }
}