package com.example.jpa_empleos.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.jpa_empleos.models.Categoria;

public interface CategoriasRepository extends CrudRepository<Categoria, Integer>{
    
}
