package com.buzzter.buzzter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.buzzter.buzzter.adapters.ViewPagerAdapter;
import com.buzzter.movil.R;

public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, ActionBar.TabListener{
	private ViewPager view_pager;
	private ViewPagerAdapter view_pager_adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		view_pager_adapter = new ViewPagerAdapter(getSupportFragmentManager());
		view_pager = (ViewPager) findViewById(R.id.view_pager);
		view_pager.setAdapter(view_pager_adapter);
		view_pager.setOnPageChangeListener(this);
		
		ActionBar bar = getSupportActionBar();
		bar.removeAllTabs();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.addTab(bar.newTab().setText(R.string.tab_noticias).setTabListener(this));
		bar.addTab(bar.newTab().setText(R.string.tab_perfil).setTabListener(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
		
	    
		return true;
	}
	public void OpenPublicacion(){
		Intent intent = new Intent(this, CrearPublicacionActivity.class);
		startActivity(intent);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu_publicacion:
	        	OpenPublicacion();
	 		   return true;
	        
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		view_pager.setCurrentItem(arg0.getPosition());
		
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPageSelected(int arg0) {
		getSupportActionBar().setSelectedNavigationItem(arg0);
		
	}

}
