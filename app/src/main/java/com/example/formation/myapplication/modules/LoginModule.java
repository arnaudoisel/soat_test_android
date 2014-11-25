package com.example.formation.myapplication.modules;

import android.content.Context;

import com.example.formation.myapplication.events.EventBus;
import com.example.formation.myapplication.models.User;
import com.example.formation.myapplication.services.LoginManager;
import com.example.formation.myapplication.services.SessionManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module (
		complete = false,
		library = true
		)
public class LoginModule {

	@Provides @Singleton
	SessionManager provideSessionManager(@ForApplication Context context, @ForApplication EventBus eventBus) {
		return new SessionManager(context, eventBus);
	}
	
	@Provides @Singleton
	LoginManager provideLoginManager(@ForApplication Context context, SessionManager sessionManager) {
		return new LoginManager(context, sessionManager);
	}
	
	@Provides
	User provideUser(LoginManager loginManager) {
		return loginManager.getUser();
	}

}
