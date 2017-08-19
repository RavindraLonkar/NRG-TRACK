package com.nrg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

	import com.nrg.models.Insurance;
	import com.nrg.utils.CommonSqlQueries;

@Repository
public interface InsuranceRepository extends CrudRepository<Insurance, Long> {

	@Query(CommonSqlQueries.GET_INSURANCES)
	List<Insurance> findUserVehiclesInsuarance(@Param(value = "userid") Integer userid);

	Insurance findInsuranceByinsuranceid(long insuranceid);

}
