package com.puc.tcc.scheduler.feign;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class MaintainerServiceFallback implements MaintainerService {

	@Override
	public String checarEntrega(CheckFeignDTO check) {
		System.out.println("Fallback");
		return ""; // TODO
	}
}