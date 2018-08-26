package com.puc.tcc.scheduler.feign;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CepServiceFallback implements CepService {


    @Override
    public Cep getCep(String cep) {
    	System.out.println("Fallback");
        return new Cep();
    }
}