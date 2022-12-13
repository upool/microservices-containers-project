package com.example.service.impl;

import com.example.dao.ILibroRepository;
import com.example.model.Libro;
import com.example.service.api.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements ILibroService {

    @Autowired
    ILibroRepository libroRepo;

    @Override
    public List<Libro> getLibros() {
        return libroRepo.findAll();
    }

    @Override
    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepo.save(libro);
    }

    @Override
    public List findByNombre(String nombre) {
        return libroRepo.findByNombre(nombre);
    }


}
