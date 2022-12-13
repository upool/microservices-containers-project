package com.example.service.impl;


import com.example.dao.ILibroRepository;
import com.example.dao.IPedidoDetalleRepository;
import com.example.dao.IPedidoRepository;
import com.example.model.Libro;
import com.example.model.Pedido;
import com.example.model.PedidoDetalle;
import com.example.request.LibrosPedidoRequest;
import com.example.request.PedidoRequest;
import com.example.response.PedidoResponse;
import com.example.service.api.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoServiceImpl implements IPedidoService {


    @Autowired
    IPedidoRepository pedidoRepo;

    @Autowired
    IPedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    ILibroRepository libroRepository;

    @Override
    public List<PedidoResponse> getPedidos() {
        List<PedidoResponse> listaPedidos = new ArrayList<>();

        PedidoResponse pedidoResponse = null;
        List<Pedido> pedidoList = pedidoRepo.findAll();
        List<PedidoDetalle> listaLibros = new ArrayList<>();
        for (Pedido pedido: pedidoList){
            pedidoResponse = new PedidoResponse();
            pedidoResponse.setPedido(pedido);
            pedidoResponse.setLibros(pedidoDetalleRepository.findByPedidoId(pedido.getId()));
            listaPedidos.add(pedidoResponse);
        }
        return listaPedidos;
    }

    public PedidoResponse save(PedidoRequest pedido) throws Exception {

        PedidoResponse pedidoResponse = null;

        for (LibrosPedidoRequest libro : pedido.getLibros()) {
            if(libroRepository.findById(libro.getLibroId()).get()==null){
                throw new Exception("No se encontró el libro en existencia");
            }
        }


            Pedido ped = new Pedido();
            ped.setDomicilio(pedido.getDomicilio());
            ped.setFechaPedido(pedido.getFechaPedido());
            ped = pedidoRepo.save(ped);

            Long pedidoId = ped.getId();
            PedidoDetalle pd = null;
            for (LibrosPedidoRequest libro : pedido.getLibros()) {
                pd = new PedidoDetalle();
                pd.setPedidoId(pedidoId);
                pd.setPrecio(libro.getPrecio());
                pd.setLibroId(libro.getLibroId());
                pedidoDetalleRepository.save(pd);
            }

            pedidoResponse = new PedidoResponse();
            pedidoResponse.setPedido(ped);
            pedidoResponse.setLibros(pedidoDetalleRepository.findByPedidoId(ped.getId()));


        return pedidoResponse;
    }
}
