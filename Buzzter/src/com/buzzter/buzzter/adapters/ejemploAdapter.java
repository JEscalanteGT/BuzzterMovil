package com.buzzter.buzzter.adapters;

import java.util.List;

import com.buzzter.buzzter.fragments.PagerItem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ejemploAdapter extends FragmentPagerAdapter{
	private List<PagerItem> Tabs;
	
	public ejemploAdapter(FragmentManager fragment, List<PagerItem> mTabs){
		super(fragment);
		Tabs = mTabs;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Tabs.size();
	}
	@Override
    public Fragment getItem(int i) {
        return Tabs.get(i).createFragment();
    }
	
	@Override
    public CharSequence getPageTitle(int position) {
        return Tabs.get(position).getTitle();
    }
	
}
