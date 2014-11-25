package com.example.formation.myapplication.widgets;

import android.content.res.Configuration;
import android.view.MenuItem;

import com.example.formation.myapplication.widgets.DrawerToggle.DrawerOpenedClosedListener;

public interface DrawerTogglePresenter {

	void syncState();
	
	void onConfigurationChanged(Configuration newConfig);
	
	boolean onOptionsItemSelected(MenuItem item);
	
	void setDrawerOpenedClosedListener(DrawerOpenedClosedListener listener);
	
}
