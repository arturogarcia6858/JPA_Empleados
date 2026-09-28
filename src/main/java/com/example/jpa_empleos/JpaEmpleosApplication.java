package com.example.jpa_empleos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.repository.CategoriasRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner{

	private final CategoriasRepository categoriasRepo;

	public JpaEmpleosApplication(CategoriasRepository categoriasRepo){
		this.categoriasRepo = categoriasRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override 
	public void run(String... args) throws Exception{
		guardar();
		eliminar();
		System.out.println(categoriasRepo);
	}

	public void guardar(){
		System.out.println("Guardando");
	}

	public void eliminar(){
		System.out.println("Eliminando");
	}

}
