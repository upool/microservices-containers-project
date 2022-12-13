package com.example.controller;


import com.example.request.PedidoRequest;
import com.example.response.PedidoResponse;
import com.example.service.api.IPedidoService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/pedidos/pedido/v1/")
@CrossOrigin("*")
public class PedidoController {

    @Autowired
    IPedidoService pedidoService;

    @Value("${queue.name}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;

    public PedidoController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PedidoResponse>> getAll() {
        List<PedidoResponse> lista = pedidoService.getPedidos();
        //if (!lista.isEmpty()) {
            return new ResponseEntity<List<PedidoResponse>>(lista, HttpStatus.OK);
        //} else {
        //    return new ResponseEntity<List<PedidoResponse>>(HttpStatus.OK);
        //}
    }

    @PostMapping(value = "/save")
    public ResponseEntity<PedidoResponse> save(@RequestBody PedidoRequest pedido) {

        try {

            PedidoResponse pedidoResult = pedidoService.save(pedido);
            if (pedidoResult != null) {
                rabbitTemplate.convertAndSend("", queueName, pedidoResult.getPedido().getId());
                return new ResponseEntity<PedidoResponse>(pedidoResult, HttpStatus.OK);
            } else {
                return new ResponseEntity<PedidoResponse>(HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<PedidoResponse>(HttpStatus.BAD_REQUEST);
        }
    }
}
