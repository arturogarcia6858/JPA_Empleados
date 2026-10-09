package com.example.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.models.Vacante;
import com.example.jpa_empleos.repository.VacantesRepositoriy;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner{
	private final VacantesRepositoriy vacantesRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		buscarVacantes();	
}

	public JpaEmpleosApplication(VacantesRepositoriy vacantesRepo){
		this.vacantesRepo = vacantesRepo;
	}

	private void buscarVacantes(){
		List<Vacante> vacantes = vacantesRepo.findAll();
		for(Vacante vacante : vacantes){
			System.out.println(vacante.getId() + ". " + vacante.getNombre());
		}
	}

}
