package com.example.jpa_empleos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa_empleos.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
}
