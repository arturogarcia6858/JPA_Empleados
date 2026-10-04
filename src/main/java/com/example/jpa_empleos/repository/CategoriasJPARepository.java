package com.example.jpa_empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_empleos.models.Categoria;

public interface CategoriasJPARepository extends JpaRepository<Categoria, Integer>{
    
}
