package com.puc.tcc.scheduler.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "microservice-deliverymaintainer", fallback = MaintainerServiceFallback.class)
public interface MaintainerService {

    @RequestMapping("/v1/main")
    String getString();
}