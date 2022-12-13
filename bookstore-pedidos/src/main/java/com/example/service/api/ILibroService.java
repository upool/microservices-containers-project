package com.example.service.api;


import com.example.model.Libro;

import java.util.List;

public interface ILibroService {

    List<Libro> getLibros();

    Libro findById(Long id);

    Libro save(Libro libro);

    List findByNombre(String nombre);

}
