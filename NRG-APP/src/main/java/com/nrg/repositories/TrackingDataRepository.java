package com.nrg.repositories;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nrg.models.TrackingData;

public interface TrackingDataRepository extends CrudRepository<TrackingData, Integer>{

	// List<TrackingData> findAllByTracker(Tracker tracker);
	 
	 	@Query("select c from TrackingData c where c.tracker.trackerid = :trackerid")
	 	List<TrackingData> findBytrackingdataid(@Param("trackerid") Integer trackerid);
	
	 	// List<TrackingData> findBycreateddateBetween(Date start, Date arrival);
	 	 
	 	 //List<TrackingData> findBytrackingdataidBetween(Integer start, Date arrival);
}
