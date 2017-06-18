package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PIR_Production;

@Transactional
public interface PIR_ProductionRepository extends CrudRepository<PIR_Production, Long>{
	
}
