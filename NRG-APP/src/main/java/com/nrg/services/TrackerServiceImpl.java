package com.nrg.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.VehiclePosition;
import com.nrg.repositories.TrackingDataRepository;
import com.nrg.utils.CommonSqlQueries;

@Service
public class TrackerServiceImpl implements TrackerService {

	@Autowired
	TrackingDataRepository trackingDataRepository;

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<CoordinateDetail> getTrackingData(Integer vehicleId, String startDate, String endDate) {
		Date d1 = null;
		Date d2 = null;
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			d1 = (Date) dt.parse(startDate);
			d2 = (Date) dt.parse(endDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<CoordinateDetail> list = trackingDataRepository.findBytrackerId(vehicleId, d1, d2);
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VehiclePosition> findVehiclePositionByDate(Integer vehicleId, String trackDate) {
		Date trackdate = null;
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			trackdate = (Date) dt.parse(trackDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Query q=entityManager.createQuery(CommonSqlQueries.GET_VEHICLES_POSITION_BY_DATE);
		q.setParameter("vehicleId", vehicleId);
		q.setParameter("trackdate", trackdate);
		q.setMaxResults(1);
		List<VehiclePosition> list =q.getResultList();
		return list;
	}

}
