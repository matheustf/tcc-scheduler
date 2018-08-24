package com.puc.tcc.scheduler.controller;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MaintainerServiceFallback implements MaintainerService {

    @Override
    public String getString() {
    	System.out.println("Fallback");
        return new String();
    }
}