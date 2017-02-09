package com.theironyard;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.theironyard.config.JerseyResourceConfig;

@SpringBootApplication
public class ExploreWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(ExploreWebApplication.class, args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration;
		registration = new ServletRegistrationBean(new ServletContainer(), "/api/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyResourceConfig.class.getName());
		return registration;
	}
}








