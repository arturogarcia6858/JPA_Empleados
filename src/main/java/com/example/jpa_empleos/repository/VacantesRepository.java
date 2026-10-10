package com.example.jpa_empleos.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa_empleos.models.EstatusVacante;
import com.example.jpa_empleos.models.Vacante;

@Repository 
public interface VacantesRepository extends JpaRepository<Vacante, Integer>{
    List<Vacante> findByEstatus(EstatusVacante estatus);

    List<Vacante> findByDestacadoAndEstatusOrderByIdDesc(int destacado, EstatusVacante estatus);
    
}
