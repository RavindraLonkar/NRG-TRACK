package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PGR_Production;

@Transactional
public interface PGR_ProductionRepository extends CrudRepository<PGR_Production, Long>{
	
}
