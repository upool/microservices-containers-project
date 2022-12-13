package com.example.controller;

import com.example.model.Envio;
import com.example.service.api.EnvioServiceAPI;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/envios/envio/v1/")
@CrossOrigin("*")
public class EnviosController {

    @Autowired
    private EnvioServiceAPI envioServiceAPI;


    @GetMapping(value = "all")
    public ResponseEntity<List<Envio>> getAll() {
        List<Envio> lista = envioServiceAPI.getAll();
        return new ResponseEntity<List<Envio>>(lista, HttpStatus.OK);
    }

}