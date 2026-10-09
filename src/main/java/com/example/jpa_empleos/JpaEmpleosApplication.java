package com.example.jpa_empleos;

import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.models.Categoria;
import com.example.jpa_empleos.models.EstatusVacante;
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
		guardarVacante();	
}

	public JpaEmpleosApplication(VacantesRepositoriy vacantesRepo){
		this.vacantesRepo = vacantesRepo;
	}

	private void buscarVacantes(){
		List<Vacante> vacantes = vacantesRepo.findAll();
		for(Vacante vacante : vacantes){
			System.out.println(vacante.getId() + ". " + vacante.getNombre() + 
		" -> " + vacante.getCategoria().getNombre());
		}
	}

	private void guardarVacante() {
    Vacante vacante = new Vacante();
    vacante.setNombre("Desarrollador Java PRO");
    vacante.setDescription("Se busca desarrollador con experiencia en Spring Boot y JPA.");
    vacante.setFecha(new Date());
    vacante.setSalario(25000.0);
    vacante.setEstatus(EstatusVacante.Creada); // Enum, asegúrate que exista en tu proyecto
    vacante.setDestacado(1);
    vacante.setImagen("logo_empresa.png");
    vacante.setDetalles("Trabajo remoto con horario flexible. Beneficios y capacitación incluidos.");

    // Crear una categoría asociada
    Categoria categoria = new Categoria();
    categoria.setId(1); // Si ya existe en la BD, solo asignas el id
    // o puedes crear una nueva:
    // categoria.setNombre("Tecnología");
    // categoria.setDescripcion("Empleos relacionados con desarrollo y TI.");

    vacante.setCategoria(categoria);
    vacantesRepo.save(vacante);
}

}
