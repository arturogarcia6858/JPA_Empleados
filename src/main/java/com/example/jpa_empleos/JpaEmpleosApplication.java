package com.example.jpa_empleos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaEmpleosApplication{


	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
		System.out.println("Servidor corriendo en el puerto 8080");
	}

}
