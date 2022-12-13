package com.example.response;

import com.example.model.Pedido;
import com.example.model.PedidoDetalle;
import lombok.Data;
import java.util.List;


@Data
public class PedidoResponse {

    private Pedido pedido;

    private List<PedidoDetalle> libros;
}
