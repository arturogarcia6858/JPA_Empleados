package com.example.jpa_empleos;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.models.Categoria;
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
		modificar();
	}

	private void modificar(){
		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(1);
		if(categoriaBuscada.isPresent()){
			Categoria categoriaTmp = categoriaBuscada.get();
			categoriaTmp.setNombre("Ingenieria de software");
			categoriaTmp.setDescripcion("Desarrollo de sistemas");
			
			categoriasRepo.save(categoriaTmp);

			System.out.println(categoriaBuscada);
			System.out.println("Categoria actualizada");
		}else{
			System.out.println("Categoría no encontrada");
		}
	}

	private void buscarPorId(){
		Optional<Categoria> categoriaBuscada = categoriasRepo.findById(5);
		if(categoriaBuscada.isPresent()){
			System.out.println(categoriaBuscada.get());
		}else{
			System.out.println("Categoria no encontrada");
		}
	}

	public void guardar(){
		System.out.println("Guardando");
		Categoria nuevaCategoria = new Categoria();

		nuevaCategoria.setNombre("Finanzas");
		nuevaCategoria.setDescripcion("Trabajos relacionados con finanzas y contabilidad");

		categoriasRepo.save(nuevaCategoria);
		System.out.println(nuevaCategoria);
	}

	public void eliminar(){
		System.out.println("Eliminando");
	}

}
