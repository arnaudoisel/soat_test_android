package com.example.formation.myapplication.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.formation.myapplication.Luncher;

import java.util.List;

import dagger.ObjectGraph;

public abstract class BaseService extends Service {

	private ObjectGraph serviceGraph;

    protected abstract List<Object> getModules();

	@Override
	public void onCreate() {
		super.onCreate();
        serviceGraph = ((Luncher) getApplication()).createScopedGraph(getModules().toArray());
        serviceGraph.inject(this);
	}
	
	@Override
	public void onDestroy() {
		serviceGraph = null;
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		// We don't provide binding, so return null
		return null;
	}

}
