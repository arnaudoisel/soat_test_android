package com.example.formation.myapplication.fragments.presenters;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.formation.myapplication.fragments.MainFragment;
import com.example.formation.myapplication.models.AuthDetails;
import com.example.formation.myapplication.services.LoginManager;
import com.example.formation.myapplication.widgets.DrawerToggle.DrawerOpenedClosedListener;
import com.example.formation.myapplication.widgets.DrawerTogglePresenter;

import javax.inject.Inject;

public abstract class MainBaseFragmentPresenter extends BaseFragmentPresenter implements MainFragmentPresenter {
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			// display view for selected nav drawer item
			MainBaseFragmentPresenter.this.view.displayView(position);
		}
	}

	@Inject
	MainFragment view;
	
	@Inject
	LoginManager loginManager;
	
	protected DrawerTogglePresenter drawerTogglePresenter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		view.setHasOptionsMenu(true);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
				
		view.setDrawerListItemClickListener(new DrawerItemClickListener());
		
		drawerTogglePresenter = view.getDrawerTogglePresenter();
		drawerTogglePresenter.setDrawerOpenedClosedListener(new DrawerOpenedClosedListener() {
			
			@Override
			public void onDrawerOpened(View drawerView) {
				view.setDrawerTitleAndHideActionBarIcons();
			}
			
			@Override
			public void onDrawerClosed(View drawerView) {
				view.setNewTitleAndShowActionBarIcons();
			}
		});
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		// Sync the toggle state after onRestoreInstanceState has occurred.
		drawerTogglePresenter.syncState();
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		
		// Pass any configuration change to the drawer toggle
		drawerTogglePresenter.onConfigurationChanged(newConfig);
	}

}
