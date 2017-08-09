package com.nrg.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.TrackingData;

public interface TrackingDataRepository extends CrudRepository<TrackingData, Integer> {

	@Query("select new com.nrg.models.CoordinateDetail(t.tracker.trackerid,t.trackingdataid,t.latitude,t.longitude) from TrackingData t where t.tracker.vechicle.vehicleid = :vehicleid and t.createddate between :start and :end order by createddate asc")
	List<CoordinateDetail> findBytrackerId(@Param("vehicleid") Integer vehicleid, @Param("start") Date start,
			@Param("end") Date end);

}
