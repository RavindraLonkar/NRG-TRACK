package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.PIR_ReturnNew;

@Transactional
public interface PIR_ReturnNewRepository extends CrudRepository<PIR_ReturnNew, Long>{
	
}
