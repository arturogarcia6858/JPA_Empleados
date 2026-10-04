package com.example.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import com.example.jpa_empleos.models.Categoria;
import com.example.jpa_empleos.repository.CategoriasJPARepository;
import com.example.jpa_empleos.repository.CategoriasRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner{
	private final CategoriasRepository categoriasRepo;
	private final CategoriasJPARepository categoriasJPARepo;

	public JpaEmpleosApplication(CategoriasRepository categoriasRepo, CategoriasJPARepository categoriasJPARepo){
		this.categoriasRepo = categoriasRepo;
		this.categoriasJPARepo = categoriasJPARepo;
	}
	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		buscarTodosOrdenados();
	}

	private void buscarTodasJPA(){
		List<Categoria> categorias = categoriasJPARepo.findAll();
		for(Categoria categoria : categorias){
			System.out.println(categoria.getId() + " " + categoria.getNombre());
		}
	}

	private void borrarTodasEnBloque(){
		categoriasJPARepo.deleteAllInBatch();
	}

	private void buscarTodosOrdenados(){
		//List<Categoria> categorias = categoriasJPARepo.findAll(Sort.by("nombre").descending());
		List<Categoria> categorias = categoriasJPARepo.findAll(Sort.by("nombre").descending());
		for(Categoria categoria : categorias){
			System.out.println(categoria.getId() + " " + categoria.getNombre());
		}
	}

}
