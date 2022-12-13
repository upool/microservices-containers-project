package com.example.listener;

import com.example.model.Envio;
import com.example.service.api.EnvioServiceAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQListener {

    @Autowired
    private EnvioServiceAPI envioServiceAPI;

    @RabbitListener(queues = "${queue.name}")
    public void onUserRegistration(Long pedidoId) {
        log.info("ENVIOS => User Registration Event Received: {}", pedidoId);
        Envio envio = new Envio();
        envio.setPedidoId(pedidoId);
        envio = envioServiceAPI.save(envio);
        log.info("envío realizado: " + envio.toString());

    }
}
