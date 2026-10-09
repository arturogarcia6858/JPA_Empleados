package com.example.jpa_empleos.controller;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_empleos.models.Perfil;
import com.example.jpa_empleos.models.Usuario;
import com.example.jpa_empleos.repository.PerfilesRepository;
import com.example.jpa_empleos.repository.UsuarioRepository;


@RestController 
@RequestMapping ("/api/jpa-usuarios")

public class controllerUsuarios {
    private final UsuarioRepository usuarioRepo;
    private final PerfilesRepository perfilesRepo;

    public controllerUsuarios(UsuarioRepository usuarioRepo, PerfilesRepository perfilesRepo){
        this.usuarioRepo = usuarioRepo;
        this.perfilesRepo = perfilesRepo;
    }

    @GetMapping("/{idUsuario}")
    private ResponseEntity<Optional<Usuario>> buscarUsuario(@PathVariable Integer idUsuario){
        Optional<Usuario> usuario = usuarioRepo.findById(idUsuario);
        return ResponseEntity.ok(usuario);
    }
    @PostMapping("")
    private ResponseEntity<Usuario> guardarUsuaario(@RequestBody Usuario usuarioInformacion){
        Usuario usuario = usuarioRepo.save(usuarioInformacion);
        return ResponseEntity.ok(usuario);

    }

    @PostMapping("/perfiles")
    private ResponseEntity<Perfil> guardarPerfiiles(@RequestBody Perfil perfilInformacion){
        Perfil perfil = perfilesRepo.save(perfilInformacion);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(perfil);
    }
}
