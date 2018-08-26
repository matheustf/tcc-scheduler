package com.puc.tcc.scheduler.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.scheduler.feign.Cep;
import com.puc.tcc.scheduler.feign.CepService;

import lombok.AllArgsConstructor;
 
@RestController
@AllArgsConstructor
@RequestMapping("v1/ceps")
public class CepController {
 
    private final CepService cepService;
 
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    public Cep getCep(@PathVariable String cep) {
        return cepService.getCep(cep);
    }
}