package com.example.service.impl;

import com.example.commons.GenericServiceImpl;
import com.example.dao.EnvioDaoAPI;
import com.example.model.Envio;
import com.example.service.api.EnvioServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EnvioServiceImpl extends GenericServiceImpl<Envio, Long> implements EnvioServiceAPI {

    @Autowired
    private EnvioDaoAPI envioDaoAPI;

    @Override
    public CrudRepository<Envio, Long> getDao() {
        return envioDaoAPI;
    }

}
