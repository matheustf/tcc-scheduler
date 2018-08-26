package com.puc.tcc.scheduler.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.amazonaws.auth.presign.PresignerParams.Builder;
import com.puc.tcc.scheduler.feign.CheckFeignDTO;
import com.puc.tcc.scheduler.feign.MaintainerService;
import com.puc.tcc.scheduler.model.Entrega;
import com.puc.tcc.scheduler.repository.EntregaRepository;

import antlr.Utils;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	MaintainerService maintainerService;

	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository, MaintainerService maintainerService) {
		this.entregaRepository = entregaRepository;
		this.maintainerService = maintainerService;
	}

	@Override
	public void atualizarEntregas() {

		List<Entrega> entregas = (List<Entrega>) entregaRepository.findAll();
		for (Entrega entrega : entregas) {
			if (StringUtils.isNotBlank(entrega.getCodigoDeRastreio())) {
				System.out.println(entrega.getCodigoDaEntrega());
				CheckFeignDTO check = CheckFeignDTO
						.builder()
						.codigoDeRastreio(entrega.getCodigoDeRastreio())
						.statusDaEntrega(entrega.getStatusDaEntrega().toString())
						.build();

				maintainerService.checarEntrega(check);
			}
		}

	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
