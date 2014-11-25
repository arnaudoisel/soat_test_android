package com.example.formation.myapplication.fragments.modules;

import com.example.formation.myapplication.activities.modules.MainActivityModule;
import com.example.formation.myapplication.fragments.FragmentView;
import com.example.formation.myapplication.fragments.LoginFragment;
import com.example.formation.myapplication.fragments.LoginFragmentImpl;
import com.example.formation.myapplication.fragments.presenters.FragmentPresenter;
import com.example.formation.myapplication.fragments.presenters.LoginFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                LoginFragmentImpl.class,
        },
        addsTo = MainActivityModule.class
)
public class LoginFragmentModule {

    private LoginFragment view;

    public LoginFragmentModule(LoginFragment view) {
        this.view = view;
    }

    @Provides @Singleton
    FragmentView provideFragmentView() {
        return view;
    }

    @Provides @Singleton
    LoginFragment provideLoginFragmentView() {
        return view;
    }

    @Provides
    @Singleton
    FragmentPresenter provideFragmentPresenter(LoginFragmentPresenter presenter) {
        return presenter;
    }

}
