package com.example.formation.myapplication.services.modules;

import com.example.formation.myapplication.modules.AppModule;
import com.example.formation.myapplication.services.AuthenticationService;

import dagger.Module;

@Module (
		injects = AuthenticationService.class,
		addsTo = AppModule.class)
public class AuthenticationServiceModule {
}
