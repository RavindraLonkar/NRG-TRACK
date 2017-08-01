package com.nrg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nrg.models.Vechicle;
import com.nrg.models.VehicleDetails;

@Repository
public interface VehicleRepository extends CrudRepository<Vechicle, Long> {

	@Query("select new com.nrg.models.VehicleDetails(v.vehicleid,v.user.userid,v.vechiclename,v.vechiclenumber) from Vechicle v where v.user.userid=:userid")
	List<VehicleDetails> findByUserId(@Param("userid") Long userid);

}
