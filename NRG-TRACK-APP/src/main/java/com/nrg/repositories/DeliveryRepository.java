package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nrg.models.Delivery;

@Transactional
public interface DeliveryRepository extends CrudRepository<Delivery, Long>{
	
}
