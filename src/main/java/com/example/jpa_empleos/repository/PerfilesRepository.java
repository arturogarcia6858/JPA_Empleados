package com.example.jpa_empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_empleos.models.Perfil;

public interface PerfilesRepository extends JpaRepository<Perfil, Integer>{
    
}
