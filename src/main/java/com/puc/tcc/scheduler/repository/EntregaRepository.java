package com.puc.tcc.scheduler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.scheduler.model.Entrega;


@Repository
public interface EntregaRepository extends MongoRepository<Entrega, String> {

	Optional<List<Entrega>> findByIdCliente(String idCliente);

}
