package com.example.jpa_empleos.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_empleos.models.EstatusVacante;
import com.example.jpa_empleos.models.Vacante;
import com.example.jpa_empleos.repository.VacantesRepository;

@RestController 
@RequestMapping ("/api/jpa-vacante")
public class VacanteController {
    private final VacantesRepository vacantesRepo;

    public VacanteController(VacantesRepository vacantesRepo){
        this.vacantesRepo = vacantesRepo;
    }

    @GetMapping("/estatus-varios")
    public ResponseEntity<List<Vacante>> variosEstatus(@RequestParam EstatusVacante[] estatus){
        List<Vacante> vacantes = vacantesRepo.findByEstatusIn(estatus);
        return ResponseEntity.ok(vacantes);
        
    }

    @GetMapping("/salario/desc")
    public ResponseEntity<List<Vacante>> rangoSalarioDesc(@RequestParam Double minimo, @RequestParam Double maximo){
        List<Vacante> vacantes = vacantesRepo.findBySalarioBetweenOrderBySalarioDesc(minimo, maximo);

        return ResponseEntity.ok(vacantes);

    }

    @GetMapping("/salario")
    public ResponseEntity<List<Vacante>> rangoSalario(@RequestParam Double minimo, @RequestParam Double maximo){
        List<Vacante> vacantes = vacantesRepo.findBySalarioBetween(minimo, maximo);

        return ResponseEntity.ok(vacantes);

    }

    @GetMapping("/destacadas")
    public ResponseEntity<List<Vacante>> destacadas(@RequestParam int destacado, @RequestParam EstatusVacante estatus){
        List<Vacante> vacantes = vacantesRepo.findByDestacadoAndEstatusOrderByIdDesc(destacado, EstatusVacante.Aprobada);
        return ResponseEntity.ok(vacantes);

    }

    @GetMapping("/estatus")
    public ResponseEntity<List<Vacante>> estatus(@RequestParam EstatusVacante estatus){
        List<Vacante> vacantes = vacantesRepo.findByEstatus(estatus);
        return ResponseEntity.ok(vacantes);

    }
    
}
