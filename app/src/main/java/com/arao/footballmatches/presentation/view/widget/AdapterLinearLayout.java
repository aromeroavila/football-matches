package com.arao.footballmatches.presentation.view.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A linear layout that will contain views taken from an adapter. It differs from the list view in
 * the fact that it will not optimize anything and draw all the views from the adapter.
 * It also does not provide scrolling.
 * <p>
 * Extracted from: http://stackoverflow.com/a/24905387
 */
public class AdapterLinearLayout extends LinearLayout {

    private List<View> childViews;
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

    public void setAdapter(Adapter adapter) {
        if (adapter != null) {
            mAdapter = adapter;
            mAdapter.registerDataSetObserver(mDataSetObserver);
        }

        reloadChildViews();
    }

    public List<View> getChildViews() {
        return childViews;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(mDataSetObserver);
        }
    }

    protected void reloadChildViews() {
        removeAllViews();

        if (mAdapter == null) {
            return;
        }

        childViews = new ArrayList<>();
        int count = mAdapter.getCount();
        for (int position = 0; position < count; position++) {
            View v = mAdapter.getView(position, null, this);
            if (v != null) {
                addView(v);
                childViews.add(v);
            }
        }

        requestLayout();
    }
}