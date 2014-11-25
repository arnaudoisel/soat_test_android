package com.example.formation.myapplication.fragments;

import android.app.Fragment;

import com.example.formation.myapplication.R;
import com.example.formation.myapplication.fragments.modules.MainLoggedInFragmentModule;

import java.util.Arrays;
import java.util.List;

public class MainLoggedInFragment extends MainBaseFragment {

	@Override
	protected List<Object> getModules() {
        return Arrays.<Object>asList(new MainLoggedInFragmentModule(this));
	}
	
	@Override
	protected Fragment getFragmentForDrawerPosition(int position) {
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new AgendaFragment();
			break;
		default:
			break;
		}
		return fragment;
	}
	
	@Override
	protected int getDrawerItemsArrayId() {
		return R.array.logged_in_drawer_items;
	}

	@Override
	protected int getOptionsMenuId() {
		return R.menu.main_logged_in;
	}

}
