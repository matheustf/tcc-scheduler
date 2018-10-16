package com.puc.tcc.scheduler.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-entrega", fallback = MaintainerServiceFallback.class)
public interface MaintainerService {

	@RequestMapping(value = "/checarEntrega", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    String checarEntrega(@RequestBody CheckFeignDTO check);
}

	
