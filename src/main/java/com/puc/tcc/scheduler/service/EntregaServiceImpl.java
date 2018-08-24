package com.puc.tcc.scheduler.service;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.gson.reflect.TypeToken;
import com.puc.tcc.scheduler.dtos.EntregaDTO;
import com.puc.tcc.scheduler.model.Entrega;
import com.puc.tcc.scheduler.repository.EntregaRepository;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	
	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	@Override
	public List<EntregaDTO> buscarTodos() {

		List<Entrega> entregas = (List<Entrega>) entregaRepository.findAll();

		Type listType = new TypeToken<List<EntregaDTO>>(){}.getType();
		List<EntregaDTO> entregasDTO = modelMapper().map(entregas, listType);
		
		
		
		
		for (EntregaDTO entregaDTO : entregasDTO) {
			System.out.println(entregaDTO.getCodigoDaEntrega());
		}

		return entregasDTO;
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
