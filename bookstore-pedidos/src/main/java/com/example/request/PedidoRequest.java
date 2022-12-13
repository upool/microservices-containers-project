package com.example.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PedidoRequest {

    private Date fechaPedido;
    private String domicilio;
    private List<LibrosPedidoRequest> libros;

}
