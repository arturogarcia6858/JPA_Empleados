package com.example.jpa_empleos;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.models.EstatusVacante;
import com.example.jpa_empleos.models.Vacante;
import com.example.jpa_empleos.repository.VacantesRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner{
	private final VacantesRepository vacantesRepo;

	public JpaEmpleosApplication(VacantesRepository vacantesRepo){
		this.vacantesRepo = vacantesRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		buscarVacatesPorDestacadoEstatus();
	}

	private void buscarVacantesPorEstatus(){
		List<Vacante> vacantesAprobadas = vacantesRepo.findByEstatus(EstatusVacante.Aprobada);
		System.out.println("Registros encontrados: " + vacantesAprobadas.size());

		for(Vacante vacante : vacantesAprobadas){
			System.out.println(vacante.getId() + ": " + vacante.getNombre() + " - " + vacante.getEstatus());
		}
	}

	private void buscarVacatesPorDestacadoEstatus(){
		List<Vacante> vacantesAprobadasYDestacadas = vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(1, EstatusVacante.Aprobada);

		System.out.println("Registros encontrados: " + vacantesAprobadasYDestacadas.size());

		for(Vacante vacante : vacantesAprobadasYDestacadas){
			System.out.println(vacante.getId() + ": " + vacante.getNombre() + " - " + vacante.getEstatus() + ", destacadas: "  + vacante.getDestacado());
		}
	}

}
