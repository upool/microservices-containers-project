package com.example.dao;

import com.example.model.Pedido;
import com.example.model.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPedidoDetalleRepository  extends JpaRepository<PedidoDetalle, Long> {


    List<PedidoDetalle> findByPedidoId(Long pedidoId);

}
