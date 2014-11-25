package com.example.formation.myapplication.fragments.modules;

import com.example.formation.myapplication.activities.modules.MainActivityModule;
import com.example.formation.myapplication.fragments.FragmentView;
import com.example.formation.myapplication.fragments.MainFragment;
import com.example.formation.myapplication.fragments.MainLoggedInFragment;
import com.example.formation.myapplication.fragments.presenters.FragmentPresenter;
import com.example.formation.myapplication.fragments.presenters.MainFragmentPresenter;
import com.example.formation.myapplication.fragments.presenters.MainLoggedInFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module (
		injects = {
				MainLoggedInFragment.class,
		},
		addsTo = MainActivityModule.class
		)
public class MainLoggedInFragmentModule {

	private MainFragment view;
	
	private MainFragmentPresenter presenter;

	public MainLoggedInFragmentModule(MainFragment view) {
		this.view = view;
	}

	@Provides @Singleton
	FragmentView provideFragmentView() {
		return view;
	}
	
	@Provides @Singleton
	MainFragment provideMainFragmentView() {
		return view;
	}

	@Provides @Singleton
	FragmentPresenter provideFragmentPresenter(MainLoggedInFragmentPresenter presenter) {
		return initPresenter(presenter);
	}

	@Provides @Singleton
	MainFragmentPresenter provideMainFragmentPresenter(MainLoggedInFragmentPresenter presenter) {
		return initPresenter(presenter);
	}
	
	MainLoggedInFragmentPresenter initPresenter(MainLoggedInFragmentPresenter presenter) {
		if (this.presenter == null)
			this.presenter = presenter;
		return presenter;		
	}

}
