package com.example.service.api;

import com.example.model.Libro;
import com.example.model.Pedido;
import com.example.request.PedidoRequest;
import com.example.response.PedidoResponse;

import java.util.List;

public interface IPedidoService {

    List<PedidoResponse> getPedidos();

    PedidoResponse save(PedidoRequest pedido) throws Exception;
}
