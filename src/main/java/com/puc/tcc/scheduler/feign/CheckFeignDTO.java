package com.puc.tcc.scheduler.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CheckFeignDTO {
	
	private String codigoDeRastreio;
	
	private String statusDaEntrega;

}
