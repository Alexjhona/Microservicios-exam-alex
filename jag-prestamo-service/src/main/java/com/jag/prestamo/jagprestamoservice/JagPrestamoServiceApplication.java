package com.jag.prestamo.jagprestamoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class JagPrestamoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(JagPrestamoServiceApplication.class, args);
	}

}
