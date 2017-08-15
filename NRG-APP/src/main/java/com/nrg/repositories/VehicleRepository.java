package com.nrg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nrg.models.Vechicle;
import com.nrg.utils.CommonSqlQueries;

@Repository
public interface VehicleRepository extends CrudRepository<Vechicle, Long> {

	@Query(CommonSqlQueries.GET_VEHICLES)
	List<Vechicle> findByUserId(@Param(value = "userid") Integer userid);

	Vechicle findVechicleByvehicleid(Integer vehicleid);
	
	@Query(CommonSqlQueries.GET_TRACKER_VEHICLES)
	List<Vechicle> findTrackerVehicleByUserId(@Param(value = "userid") Integer userid);

}
