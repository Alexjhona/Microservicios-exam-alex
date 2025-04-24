package com.jag.registryservice.jagregistryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JagRegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JagRegistryServiceApplication.class, args);
	}

}
