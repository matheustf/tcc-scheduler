package com.puc.tcc.scheduler.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.puc.tcc.scheduler.enums.StatusDaEntrega;

@FeignClient(value = "microservice-deliverymaintainer", fallback = MaintainerServiceFallback.class)
public interface MaintainerService {

    @PostMapping("/checkdelivery/{codigoDeRastreio}/{statusDaEntrega}")
    String checarEntrega(@PathVariable("codigoDeRastreio") String codigoRastreio, @PathVariable("statusDaEntrega") StatusDaEntrega statusDaEntrega);
}