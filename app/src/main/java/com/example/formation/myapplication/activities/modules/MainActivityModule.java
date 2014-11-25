package com.example.formation.myapplication.activities.modules;

import android.app.Fragment;
import android.content.Context;

import com.example.formation.myapplication.activities.ActivityView;
import com.example.formation.myapplication.activities.MainActivity;
import com.example.formation.myapplication.activities.MainActivityImpl;
import com.example.formation.myapplication.activities.presenters.ActivityPresenter;
import com.example.formation.myapplication.activities.presenters.MainActivityPresenter;
import com.example.formation.myapplication.activities.presenters.MainActivityPresenterImpl;
import com.example.formation.myapplication.fragments.LoginFragmentImpl;
import com.example.formation.myapplication.fragments.MainLoggedInFragment;
import com.example.formation.myapplication.models.User;
import com.example.formation.myapplication.modules.AppModule;
import com.example.formation.myapplication.modules.ForActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module (
		injects = MainActivityImpl.class,
        library = true,
		addsTo = AppModule.class
		)
public class MainActivityModule {

	private MainActivityImpl view;

	public MainActivityModule(MainActivityImpl view) {
		this.view = view;
	}

	@Provides @Singleton @ForActivity Context provideActivityContext() {
		return view;
	}

	@Provides
	ActivityView provideActivityView() {
		return view;
	}
	
	@Provides @Singleton
	MainActivity provideView() {
		return view;
	}

	@Provides @Singleton
	ActivityPresenter providePresenter(MainActivityPresenter presenter) {
		return presenter;
	}

	@Provides @Singleton
	MainActivityPresenter providePresenter(MainActivityPresenterImpl presenter) {
		return presenter;
	}

	@Provides
	Fragment provideContentFragment(User user) {
		if (user == null)
			return new LoginFragmentImpl();
		else
			return new MainLoggedInFragment();
	}

}
