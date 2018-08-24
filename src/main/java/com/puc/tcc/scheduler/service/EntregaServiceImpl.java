package com.puc.tcc.scheduler.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.puc.tcc.scheduler.controller.MaintainerService;
import com.puc.tcc.scheduler.model.Entrega;
import com.puc.tcc.scheduler.repository.EntregaRepository;

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
			System.out.println(entrega.getCodigoDaEntrega());
			maintainerService.checarEntrega(entrega.getCodigoDaEntrega(), entrega.getStatusDaEntrega());
		}
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
