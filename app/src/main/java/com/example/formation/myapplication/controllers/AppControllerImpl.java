package com.example.formation.myapplication.controllers;

import com.example.formation.myapplication.events.EventBus;
import com.example.formation.myapplication.events.RestartCurrentAndTerminateOthersActivitiesEvent;
import com.example.formation.myapplication.events.SessionUpdatedEvent;
import com.example.formation.myapplication.modules.ForApplication;

import javax.inject.Inject;

public class AppControllerImpl implements AppController {

	private EventBus eventBus;

	@Inject
	public AppControllerImpl(@ForApplication EventBus eventBus) {
		this.eventBus = eventBus;
		this.eventBus.register(this);
	}
	
	public void onEvent(SessionUpdatedEvent event) {
		doRestartCurrentActivityAndTerminateOthers();
	}
	
	private void doRestartCurrentActivityAndTerminateOthers() {
		eventBus.post(new RestartCurrentAndTerminateOthersActivitiesEvent());
	}
}
