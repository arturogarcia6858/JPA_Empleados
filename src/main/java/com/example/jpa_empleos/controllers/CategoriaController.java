package com.example.jpa_empleos.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_empleos.models.Categoria;
import com.example.jpa_empleos.repository.CategoriasRepository;




@RestController 
@RequestMapping ("/api/categorias")
public class CategoriaController {

    private final CategoriasRepository categoriasRepo;

    public CategoriaController(CategoriasRepository categoriasRepo){
        this.categoriasRepo = categoriasRepo;
    }

    @GetMapping("")
    public Iterable<Categoria> obtenerTodos(){
		Iterable<Categoria> categorias = categoriasRepo.findAll();
		return categorias;
	}

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Integer id){
        return categoriasRepo.findById(id)
            .map(categoria -> ResponseEntity.ok(categoria))
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable Integer id, @RequestBody Categoria categoriaInformacion){
        Optional<Categoria> categoriaBuscada = categoriasRepo.findById(id);
        if(categoriaBuscada.isPresent()){
            Categoria categoriaTmp = categoriaBuscada.get();
            categoriaTmp.setNombre(categoriaInformacion.getNombre());
            categoriaTmp.setDescripcion(categoriaInformacion.getDescripcion());
            categoriasRepo.save(categoriaTmp);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaTmp);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoriaInformacion){
		Categoria nuevaCategoria = categoriasRepo.save(categoriaInformacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
	}

    @DeleteMapping("/{id}") 
    public ResponseEntity<Categoria> eliminar(@PathVariable Integer id){
        Optional<Categoria> categoriaEncontrada = categoriasRepo.findById(id);
        if(categoriaEncontrada.isPresent()){
            Categoria categoriaaux = categoriaEncontrada.get();
            categoriasRepo.delete(categoriaaux);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
}
