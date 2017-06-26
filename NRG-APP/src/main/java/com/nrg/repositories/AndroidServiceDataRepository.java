package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nrg.models.TrackingData;

public interface AndroidServiceDataRepository extends CrudRepository<TrackingData, Integer>{

}
