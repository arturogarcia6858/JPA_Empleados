package com.example.jpa_empleos;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa_empleos.models.Categoria;
import com.example.jpa_empleos.models.EstatusVacante;
import com.example.jpa_empleos.models.Perfil;
import com.example.jpa_empleos.models.Usuario;
import com.example.jpa_empleos.models.Vacante;
import com.example.jpa_empleos.repository.PerfilesRepository;
import com.example.jpa_empleos.repository.UsuarioRepository;
import com.example.jpa_empleos.repository.VacantesRepository;

@SpringBootApplication
public class JpaEmpleosApplication implements CommandLineRunner{
	private final VacantesRepository vacantesRepo;
	private final PerfilesRepository perfilesRepo;
	private final UsuarioRepository usuarioRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaEmpleosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		crearUsuarioConPerfiles();	
}

	public JpaEmpleosApplication(VacantesRepository vacantesRepo, PerfilesRepository perfilesRepo, UsuarioRepository usuarioRepo){
		this.vacantesRepo = vacantesRepo;
		this.perfilesRepo = perfilesRepo;
		this.usuarioRepo = usuarioRepo;
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

	private void crearPerfiles(){
		perfilesRepo.saveAll(obtenerPerfiles());
	}

	private List<Perfil> obtenerPerfiles(){
		List<Perfil> perfiles = new LinkedList<>();
		Perfil perfil1 = new Perfil();
		perfil1.setPerfil("SUPERVISOR");
		Perfil perfil2 = new Perfil();
		perfil2.setPerfil("ADMINISTRADOR");
		Perfil perfil3 = new Perfil();
		perfil3.setPerfil("USUARIO");

		perfiles.add(perfil1);
		perfiles.add(perfil2);
		perfiles.add(perfil3);

		return perfiles;

	}

	private void crearUsuarioConPerfiles(){
		Usuario usuarioN = new Usuario();
		usuarioN.setNombre("José García");
		usuarioN.setEmail("jose2@gmail.com");
		usuarioN.setUsername("joseg2");
		usuarioN.setPassword("12345");
		usuarioN.setEstatus(1);
		usuarioN.setFechaRegistro(LocalDate.now());

		Perfil perfil1 = new Perfil();
		perfil1.setId(6);
		
		Perfil perfil2 = new Perfil();
		perfil2.setId(7);


		Set<Perfil> perfilesUsuario = new HashSet<>();
		perfilesUsuario.add(perfil1);
		perfilesUsuario.add(perfil2);

		usuarioN.setPerfiles(perfilesUsuario);

		usuarioRepo.save(usuarioN);
	}

	private void buscarUsuario(){
		Optional<Usuario> usuarioOptional = usuarioRepo.findById(1);
		if(usuarioOptional.isPresent()){
			Usuario usuario = usuarioOptional.get();
			System.out.println("Nombre: " + usuario.getNombre());
			System.out.println("Perfiles asignados");
			for(Perfil perfil : usuario.getPerfiles()){
				System.out.println(perfil.getId());
			}
		}
	}

}
