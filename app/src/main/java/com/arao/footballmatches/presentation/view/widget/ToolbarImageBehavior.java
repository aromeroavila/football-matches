package com.arao.footballmatches.presentation.view.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.arao.footballmatches.R;

/**
 * Inspired by https://github.com/saulmm/CoordinatorBehaviorExample/
 */
public class ToolbarImageBehavior extends CoordinatorLayout.Behavior<ImageView> {

    private Context mContext;

    private float mStartXPosition;
    private float mFinalXPosition;
    private float mStartYPosition;
    private float mFinalYPosition;
    private float mFinalSize;
    private boolean mFinalAlignParentRight;

    private int mStartSize;
    private float mStartToolbarPosition;
    private float mChangeBehaviorPoint;

    public ToolbarImageBehavior(Context context, AttributeSet attrs) {
        mContext = context;

        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ToolbarImageBehavior);
            mStartXPosition = a.getDimension(R.styleable.ToolbarImageBehavior_startXPosition, 0);
            mFinalXPosition = a.getDimension(R.styleable.ToolbarImageBehavior_finalXPosition, 0);
            mStartYPosition = a.getDimension(R.styleable.ToolbarImageBehavior_startYPosition, 0);
            mFinalYPosition = a.getDimension(R.styleable.ToolbarImageBehavior_finalYPosition, 0);
            mFinalSize = a.getDimension(R.styleable.ToolbarImageBehavior_finalSize, 0);
            mFinalAlignParentRight = a.getBoolean(R.styleable.ToolbarImageBehavior_finalAlignmentToRight, false);

            a.recycle();
        }
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView child, View dependency) {
        return dependency instanceof Toolbar;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView child, View dependency) {
        maybeInitProperties(parent, child, dependency);

        final int maxScrollDistance = (int) (mStartToolbarPosition);
        float expandedPercentageFactor = dependency.getY() / maxScrollDistance;

        if (expandedPercentageFactor < mChangeBehaviorPoint) {
            float heightFactor = (mChangeBehaviorPoint - expandedPercentageFactor) / mChangeBehaviorPoint;

            float distanceXToSubtract = ((mStartXPosition - mFinalXPosition)
                    * heightFactor) + (child.getHeight() / 2);
            float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
                    * (1f - expandedPercentageFactor)) + (child.getHeight() / 2);

            child.setX(mStartXPosition - distanceXToSubtract);
            child.setY(mStartYPosition - distanceYToSubtract);

            float heightToSubtract = ((mStartSize - mFinalSize) * heightFactor);

            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            lp.width = (int) (mStartSize - heightToSubtract);
            lp.height = (int) (mStartSize - heightToSubtract);
            child.setLayoutParams(lp);
        } else {
            float distanceYToSubtract = ((mStartYPosition - mFinalYPosition)
                    * (1f - expandedPercentageFactor)) + (mStartSize / 2);

            child.setX(mStartXPosition - child.getWidth() / 2);
            child.setY(mStartYPosition - distanceYToSubtract);

            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
            lp.width = mStartSize;
            lp.height = mStartSize;
            child.setLayoutParams(lp);
        }
        return true;
    }

    @SuppressLint("PrivateResource")
    private void maybeInitProperties(CoordinatorLayout parent, ImageView child, View dependency) {
        if (mStartYPosition == 0) {
            mStartYPosition = (int) (dependency.getY());
        }

        if (mFinalYPosition == 0) {
            mFinalYPosition = (dependency.getHeight() / 2);
        }

        if (mStartSize == 0) {
            mStartSize = child.getHeight();
        }

        if (mStartXPosition == 0) {
            mStartXPosition = (int) (child.getX() + (child.getWidth() / 2));
        }

        if (mFinalXPosition == 0) {
            mFinalXPosition = mContext.getResources().getDimensionPixelOffset(R.dimen.abc_action_bar_content_inset_material) + ((int) mFinalSize / 2);
        }

        if (mFinalAlignParentRight) {
            float parentRightEnd = parent.getX() + parent.getWidth();
            mFinalXPosition = parentRightEnd - mFinalSize;
        }

        if (mStartToolbarPosition == 0) {
            mStartToolbarPosition = dependency.getY();
        }

        if (mChangeBehaviorPoint == 0) {
            mChangeBehaviorPoint = (child.getHeight() - mFinalSize) / (2f * (mStartYPosition - mFinalYPosition));
        }
    }

}
