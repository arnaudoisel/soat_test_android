package com.example.formation.myapplication.fragments;

import android.widget.AdapterView.OnItemClickListener;

import com.example.formation.myapplication.widgets.DrawerTogglePresenter;

public interface MainFragment extends FragmentView {

	DrawerTogglePresenter getDrawerTogglePresenter();

	void displayView(int position);

	void setDrawerListItemClickListener(OnItemClickListener listener);

	void setDrawerTitleAndHideActionBarIcons();

	void setNewTitleAndShowActionBarIcons();

}
