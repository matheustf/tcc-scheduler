package com.puc.tcc.scheduler.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "cepService", url = "http://api.postmon.com.br", fallback = CepServiceFallback.class)
public interface CepService {

    @RequestMapping("/v1/cep/{cep}")
    Cep getCep(@PathVariable("cep") String cep);
}