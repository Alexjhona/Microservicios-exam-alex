package com.jag.configserver.jagconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class JagConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JagConfigServerApplication.class, args);
	}

}
