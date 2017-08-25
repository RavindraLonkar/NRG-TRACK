package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.Insurance;
import com.nrg.models.InsuranceDetails;
import com.nrg.services.InsuranceService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/insurance")
public class InsuranceLipton {
	@Autowired
	InsuranceService insuranceService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Response getInsuranceList(HttpServletRequest request) {
		Response response = null;
		try {
			String userid = request.getParameter("userId");
			List<InsuranceDetails> insurance = insuranceService.getInsuranceList(Integer.parseInt(userid));

			if (insurance.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, 0, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, insurance, CommonUserMessages.INSURANCE_LOADED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response addInsurance(@RequestBody Insurance insurance, HttpServletRequest request) {
		Response response = null;
		try {
			String userid = request.getParameter("userId");
			Integer vehicleid = Integer.parseInt(request.getParameter("vehicleid"));
			Insurance addedInsurance = insuranceService.addInsurance(insurance, vehicleid, userid);

			if (addedInsurance == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, addedInsurance,
						CommonUserMessages.INSURANCE_ADDED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Response updateInsurance(@RequestBody Insurance insurance, HttpServletRequest request) {
		Response response = null;
		try {
			Insurance updatedInsurance = insuranceService.updateInsurance(insurance);

			if (updatedInsurance == null) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, updatedInsurance,
						CommonUserMessages.INSURANCE_UPDATED);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Response deleteInsurances(@RequestBody List<Insurance> insurances) {
		Response response = null;
		try {
			insuranceService.deleteInsurances(insurances);
			response = new Response(CommonConstants.NRG_SCUCESS, 1, CommonUserMessages.INSURANCES_DELETED);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

}
