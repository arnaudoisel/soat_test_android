package com.example.formation.myapplication;

import android.app.Application;

import com.example.formation.myapplication.controllers.AppController;
import com.example.formation.myapplication.modules.AppModule;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class Luncher extends Application {

	private ObjectGraph applicationGraph;

	@Inject
	AppController appController;

	@Override
	public void onCreate() {
		super.onCreate();

		applicationGraph = ObjectGraph.create(getModules().toArray());
		applicationGraph.inject(this);
	}


	/**
	 * A list of modules to use for the application graph. Subclasses can override this method to
	 * provide additional modules provided they call {@code super.getModules()}.
	 */
	protected List<Object> getModules() {
		return Arrays.<Object>asList(new AppModule(this));
	}

    public ObjectGraph createScopedGraph(Object... modules) {
        return applicationGraph.plus(modules);
    }

}
