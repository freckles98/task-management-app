package com.chelseavancoller.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("****** INSPECTING BEANS ******");

			// Check if the Controller bean exists
			boolean hasController = ctx.containsBean("authenticationController");
			boolean hasTaskController = ctx.containsBean("taskController");

			System.out.println("Is AuthenticationController loaded? " + hasController);
			System.out.println("Is TaskController loaded? " + hasTaskController);

			System.out.println("******************************");
		};
	}

}
