package com.microservice.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient //Es buena practica ponerlo aunque no es obligatoria, pero es para indicarle que es un servicio de eureka
@SpringBootApplication
public class MicroserviceStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceStudentApplication.class, args);
	}

}
