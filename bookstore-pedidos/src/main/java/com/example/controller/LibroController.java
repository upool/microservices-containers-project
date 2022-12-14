package com.example.controller;


import com.example.model.Libro;
import com.example.service.api.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pedidos/libro/v1/")
@CrossOrigin("*")
public class LibroController {

    @Autowired
    ILibroService libroService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Libro>> getAll() {
        List<Libro> lista= libroService.getLibros();
        return new ResponseEntity<List<Libro>>(lista, HttpStatus.OK);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Libro> find(@PathVariable Long id) {
        Libro obj = libroService.findById(id);
        if(obj == null){
            return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Libro>(obj, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Libro> save(@RequestBody Libro libro) {
        Libro obj = libroService.save(libro);
        return new ResponseEntity<Libro>(obj, HttpStatus.OK);
    }

}
