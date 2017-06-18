package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.Dispatch_Return_Master;

@Transactional
public interface Dispatch_Return_MasterRepository extends CrudRepository<Dispatch_Return_Master, Long>{
	
}
