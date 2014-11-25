package com.example.formation.myapplication.modules;

import android.content.Context;

import com.example.formation.myapplication.Luncher;
import com.example.formation.myapplication.controllers.AppController;
import com.example.formation.myapplication.controllers.AppControllerImpl;
import com.example.formation.myapplication.events.EventBus;
import com.example.formation.myapplication.events.EventBusImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module (
		injects = Luncher.class,
		includes = LoginModule.class
		)
public class AppModule {

	private final Luncher app;

	public AppModule(Luncher app) {
		this.app = app;
	}

	@Provides @Singleton
	AppController provideAppController(AppControllerImpl appController) {
		return appController;
	}
	
	@Provides @Singleton @ForApplication 
	Context provideApplicationContext() {
		return app;
	}

	@Provides @Singleton @ForApplication
	EventBus provideEventBus() {
		return new EventBusImpl(de.greenrobot.event.EventBus.getDefault());
	}

}
