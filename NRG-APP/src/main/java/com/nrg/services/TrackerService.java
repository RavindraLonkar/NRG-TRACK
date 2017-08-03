package com.nrg.services;

import java.util.List;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.Tracker;
import com.nrg.models.TrackingData;
import com.nrg.models.Vechicle;

public interface TrackerService {

	List<CoordinateDetail> getTrackingData(Tracker tracker);
	List<TrackingData> findLatestPosition(Integer userid);
}
