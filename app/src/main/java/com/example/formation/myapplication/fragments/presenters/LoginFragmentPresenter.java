package com.example.formation.myapplication.fragments.presenters;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.formation.myapplication.fragments.LoginFragment;
import com.example.formation.myapplication.modules.ForApplication;

import javax.inject.Inject;

public class LoginFragmentPresenter extends BaseFragmentPresenter {

    @Inject
    LoginFragment view;

    @Inject
    @ForApplication
    Context applicationContext;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        view.setLoginClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                login();
            }
        });
    }

    private void login() {
        Toast.makeText(applicationContext, "Login !", Toast.LENGTH_LONG).show();
    }
}
