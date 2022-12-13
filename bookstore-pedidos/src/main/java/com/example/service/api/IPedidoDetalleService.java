package com.example.service.api;

import com.example.model.Pedido;
import com.example.model.PedidoDetalle;
import com.example.request.PedidoRequest;

import java.util.List;

public interface IPedidoDetalleService {

    List<PedidoDetalle> getPedidosDetalle();

    PedidoDetalle save(PedidoDetalle pedidoDetalle);
}
