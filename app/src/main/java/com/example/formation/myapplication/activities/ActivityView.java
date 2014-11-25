package com.example.formation.myapplication.activities;

import android.app.Activity;
import android.os.Bundle;

public interface ActivityView {
	
	void setView(Bundle savedInstanceState);
	
	boolean isVisible();
		
	Activity getActivity();
	
}
