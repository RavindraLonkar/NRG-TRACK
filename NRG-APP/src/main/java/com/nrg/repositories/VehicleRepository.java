package com.nrg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.User;
import com.nrg.models.Vechicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vechicle, Long> {


	List<Vechicle> findAllByUser(User user);

}
