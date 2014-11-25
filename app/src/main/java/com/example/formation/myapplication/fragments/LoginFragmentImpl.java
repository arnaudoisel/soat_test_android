package com.example.formation.myapplication.fragments;

import android.view.View;
import android.widget.Button;

import com.example.formation.myapplication.R;
import com.example.formation.myapplication.fragments.modules.LoginFragmentModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.InjectView;

public class LoginFragmentImpl extends BaseFragment implements LoginFragment {


    @InjectView(R.id.login_button)
    Button loginButton;

    @Inject
    public LoginFragmentImpl() {
        super();
    }

    @Override
    protected List<Object> getModules() {
        return Arrays.<Object>asList(new LoginFragmentModule(this));
    }

    @Override
    protected int getViewId() {
        return R.layout.fragment_login;
    }

    @Override
    protected int getOptionsMenuId() {
        return 0;
    }

    @Override
    public void setLoginClickListener(View.OnClickListener listener) {
        loginButton.setOnClickListener(listener);
    }
}
