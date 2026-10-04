package com.example.jpa_empleos.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_empleos.models.Categoria;
import com.example.jpa_empleos.repository.CategoriasJPARepository;


@RestController 
@RequestMapping ("/api/jpa-categorias")
public class CategoriaJPAController {
    private CategoriasJPARepository categoriasJPARepo;

    public CategoriaJPAController(CategoriasJPARepository categoriasJPARepo){
		this.categoriasJPARepo = categoriasJPARepo;
	}

    @GetMapping ("")
    public List<Categoria> obtenerTodos(){
        List<Categoria> categorias = categoriasJPARepo.findAll();
        return categorias;
    }

    @GetMapping("/ordenadas")
    public List<Categoria> ordenadas(){
        List<Categoria> categorias = categoriasJPARepo.findAll(Sort.by("nombre").descending());
        return categorias;
    }

    @GetMapping("/paginadas")
    public Page<Categoria> paginadas(
        @RequestParam (name = "pagina", defaultValue = "0") Integer pagina,
        @RequestParam (name = "cantidad", defaultValue = "5") Integer cantidad){
        Page<Categoria> page  = categoriasJPARepo.findAll(PageRequest.of(pagina,cantidad));
		return page;
    }

    @GetMapping("/paginadas/ordenadas")
    public Page<Categoria> paginadasOrdenadas(
        @RequestParam (name = "pagina", defaultValue = "0") Integer pagina,
        @RequestParam (name = "cantidad", defaultValue = "5") Integer cantidad){
        Page<Categoria> page  = categoriasJPARepo.findAll(PageRequest.of(pagina,cantidad, Sort.by("nombre").descending()
        ));
		return page;
    }

    @DeleteMapping ("/todas")
    public ResponseEntity<Categoria> eliminarTodas(){
        categoriasJPARepo.deleteAllInBatch();
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    
    
}
