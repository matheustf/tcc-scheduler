package com.puc.tcc.scheduler.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.puc.tcc.scheduler.enums.StatusDaEntrega;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MaintainerServiceFallback implements MaintainerService {

    @Override
    public String checarEntrega(@PathVariable("codigoDeRastreio") String codigoDeRastreio, @PathVariable("statusDaEntrega") StatusDaEntrega statusDaEntrega) {
    	return ""; //TODO 
    }
}