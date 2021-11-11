package com.example.demo.model.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Principal extends Thread{

    private static final Logger log = LoggerFactory.getLogger(Principal.class);

    public int id;

    public void run () {
        log.info("Método run clase Principal {}",id);
    }

    public Principal(int id) {
        this.id = id;
    }
}
