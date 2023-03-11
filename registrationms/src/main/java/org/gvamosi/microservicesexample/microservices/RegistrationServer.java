package org.gvamosi.microservicesexample.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Paul Chapman, Gergely Vamosi
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

	public static final String REGISTRATION_SERVER_HOSTNAME = "registration.server.hostname";

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "registration-server");
		SpringApplication.run(RegistrationServer.class, args);
	}

}
