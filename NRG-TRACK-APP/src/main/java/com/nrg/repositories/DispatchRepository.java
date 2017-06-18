package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.Dispatch;

@Transactional
public interface DispatchRepository extends CrudRepository<Dispatch, Long>{
	
}
