package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.Contamination;



@Transactional
public interface ContaminationRepository extends CrudRepository<Contamination, Long>{
	
}
