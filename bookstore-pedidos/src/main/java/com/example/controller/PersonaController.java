package com.example.controller;

import com.example.model.Persona;
import com.example.service.api.PersonaServiceAPI;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pedidos/v1/")
@CrossOrigin("*")
public class PersonaController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;


    @GetMapping(value = "/all")
    public List<Persona> getAll() {
        return personaServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Persona find(@PathVariable Long id) {
        return personaServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        Persona obj = personaServiceAPI.save(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        Persona persona = personaServiceAPI.get(id);
        if (persona != null) {
            personaServiceAPI.delete(id);
        }else {
            return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }

}