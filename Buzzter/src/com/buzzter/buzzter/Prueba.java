package com.buzzter.buzzter;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.buzzter.buzzter.adapters.ejemploAdapter;
import com.buzzter.buzzter.database.SessionManager;
import com.buzzter.buzzter.fragments.NoticiasListFragment;
import com.buzzter.buzzter.fragments.PagerItem;
import com.buzzter.buzzter.fragments.PerfilFragment;
import com.buzzter.buzzter.utils.ConstantsUtils;
import com.buzzter.buzzter.views.SlidingTabLayout;
import com.buzzter.movil.R;

public class Prueba extends ActionBarActivity {
	private ViewPager view_pager;
	private SessionManager session;
	private SlidingTabLayout mSlidingTabLayout;
    private List<PagerItem> Tabs;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba);
		ConstantsUtils.showOverflowMenu(getApplicationContext());
		session = new SessionManager(getApplicationContext());
		Toast toast1 = Toast.makeText(getApplicationContext(), session.getUser(), Toast.LENGTH_LONG);
        toast1.show();
		Tabs = new ArrayList<PagerItem>();
		Tabs.add(new PagerItem(
                getString(R.string.tab_noticias), // Title
               new NoticiasListFragment()
		));
		Tabs.add(new PagerItem(
                getString(R.string.tab_perfil), // Title
                new PerfilFragment()
		));
		view_pager = (ViewPager) findViewById(R.id.view_pager);
		view_pager.setAdapter(new ejemploAdapter(getSupportFragmentManager(), Tabs));
		
		//view_pager_adapter = new ViewPagerAdapter(getSupportFragmentManager());
		//view_pager = (ViewPager) findViewById(R.id.view_pager);
		//view_pager.setAdapter(view_pager_adapter);
		
		mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setViewPager(view_pager);
		
		mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
			 
            @Override
            public int getIndicatorColor(int position) {
                return Tabs.get(position).getIndicatorColor();
            }
 
            @Override
            public int getDividerColor(int position) {
                return Tabs.get(position).getDividerColor();
            }
 
        });
		
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
	
	public void startLoginActivity(){
		session.logoutUser();
		Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
	        case R.id.menu_publicacion:
	        	OpenPublicacion();
	 		   	return true;
	        case R.id.menu_logout:
	        	startLoginActivity();
	 		   	return true;
	        default:
	            return super.onOptionsItemSelected(item);
		}
	}
}
