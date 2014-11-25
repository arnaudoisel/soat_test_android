package com.example.formation.myapplication.events;

import com.example.formation.myapplication.models.User;

public class SessionUpdatedEvent {

	private User user;
	
	public SessionUpdatedEvent(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
