package com.nrg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.CoordinateDetail;
import com.nrg.models.VehiclePosition;
import com.nrg.services.TrackerService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/tracker")
public class TrackerFacade {
	@Autowired
	TrackerService trackerService;

	@RequestMapping(value = "/trackingCoordinatesByDate", method = RequestMethod.GET)
	public Response getTrackingData(HttpServletRequest request) {

		Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		Response response = null;
		List<CoordinateDetail> list = new ArrayList<CoordinateDetail>();
		try {
			list = trackerService.getTrackingData(vehicleId, startDate, endDate);
			if (list.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, list, null);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/date/position", method = RequestMethod.GET)
	public Response vehicleDatePositions(HttpServletRequest request) {
		Response response = null;
		try {
			Integer vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
			String trackDate=request.getParameter("trackDate");
			List<VehiclePosition> vehicle = trackerService.findVehiclePositionByDate(vehicleId, trackDate);

			if (vehicle.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, vehicle, null);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}
}
