package com.buzzter.buzzter.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.buzzter.buzzter.fragments.NoticiasListFragment;
import com.buzzter.buzzter.fragments.PerfilFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
	private Fragment[] fragments;
	public ViewPagerAdapter(FragmentManager fragment){
		super(fragment);
		fragments = new Fragment[]{
			new NoticiasListFragment(),
			new PerfilFragment()
		};
	}
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragments[arg0];
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragments.length;
	}
	
}
