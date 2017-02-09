package com.theironyard.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.theironyard.controllers.api.PeopleController;

public class JerseyResourceConfig extends ResourceConfig {
	public JerseyResourceConfig() {
		register(PeopleController.class);
	}
}
