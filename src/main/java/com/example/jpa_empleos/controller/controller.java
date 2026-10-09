package com.example.jpa_empleos.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_empleos.models.Vacante;
import com.example.jpa_empleos.repository.VacantesRepository;


@RestController 
@RequestMapping ("/api/jpa-vacantes")

public class controller {
    private final VacantesRepository vacantesRepo;

    public controller(VacantesRepository vacantesRepo){
        this.vacantesRepo = vacantesRepo;
    }

    @GetMapping("/jpa-vacante")
    private ResponseEntity<List<Vacante>> vacantes(){
        List<Vacante> vacantes = vacantesRepo.findAll();
        return ResponseEntity.ok(vacantes);
    }

    @PostMapping("/jpa-vacante")
    private ResponseEntity<Vacante> guardar(@RequestBody Vacante informacionVacante){
        Vacante vacanteNuevo = vacantesRepo.save(informacionVacante);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(vacanteNuevo);
    }
    
}
