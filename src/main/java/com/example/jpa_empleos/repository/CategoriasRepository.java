package com.example.jpa_empleos.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa_empleos.models.Categoria;

@Repository
public interface CategoriasRepository extends CrudRepository<Categoria, Integer> {
    // Spring Data JPA implementará esto automáticamente
}