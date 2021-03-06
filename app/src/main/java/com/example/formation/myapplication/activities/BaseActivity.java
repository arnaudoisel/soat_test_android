package com.example.formation.myapplication.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.example.formation.myapplication.Luncher;
import com.example.formation.myapplication.activities.presenters.ActivityPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.ObjectGraph;

/**
 * 
 * Base class for all activities of the application.
 * Main features are:
 * - listen to session updates
 *
 */
public abstract class BaseActivity extends Activity implements ActivityView {

	private boolean visible = false;

	private ObjectGraph activityGraph;

	@Inject
	ActivityPresenter presenter;

	/**
	 * Direct container, it is replaced 
	 */
	@Inject
	Fragment contentFragment;

	public ObjectGraph createScopedGraph(Object... modules) {
		return activityGraph.plus(modules);
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public Activity getActivity() {
		return this;
	}

	@Override
	public void setView(Bundle savedInstanceState) {
		setContentView(getLayout());
		ButterKnife.inject(this);
		addContentFragment();
	}

	@Override
	public void setTitle(CharSequence title) {
		getActionBar().setTitle(title);
	}

	protected abstract int getLayout();
	protected abstract int getContainer();
	protected abstract List<Object> getModules();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		activityGraph = ((Luncher) getApplication()).createScopedGraph(getModules().toArray());
		activityGraph.inject(this);

		presenter.onCreate(savedInstanceState);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		presenter.onRestart();
	}

	@Override
	protected void onStart() {
		super.onStart();
		presenter.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
		this.visible = true;
		presenter.onResume();
	}

	@Override
	protected void onPause() {
		this.visible = false;
		presenter.onPause();
		super.onPause();
	}

	@Override
	protected void onStop() {
		presenter.onStop();
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		presenter.onDestroy();
		activityGraph = null;
		super.onDestroy();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		presenter.onSaveInstanceState(outState);
	}
	
	private void addContentFragment() {
		int fragmentContainerId = getContainer();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
		.add(fragmentContainerId, contentFragment).commit();
	}

}
