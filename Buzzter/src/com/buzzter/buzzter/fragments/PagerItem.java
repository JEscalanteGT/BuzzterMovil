package com.buzzter.buzzter.fragments;

import com.buzzter.movil.R;
import android.support.v4.app.ListFragment;

public class PagerItem {
	private final CharSequence mTitle;
    private static final int mIndicatorColor = R.color.buzzter_color;
    private static final int mDividerColor = R.color.actionbar_text;
    private final ListFragment mFragment;

    public PagerItem(CharSequence title, ListFragment fragment) {
        mTitle = title;
        mFragment = fragment;
        
    }

    public ListFragment createFragment() {
        return mFragment;
    }

     public CharSequence getTitle() {
        return mTitle;
    }

    public int getIndicatorColor() {
        return mIndicatorColor;
    }

    public int getDividerColor() {
        return mDividerColor;
    }
}
