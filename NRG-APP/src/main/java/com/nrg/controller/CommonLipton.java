package com.nrg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.Codevalue;
import com.nrg.services.CommonService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/commonlipton")
public class CommonLipton {

	@Autowired
	CommonService commonService;

	@RequestMapping(value = "/codevalue", method = RequestMethod.GET)
	public Response getVehiclesOfUser(HttpServletRequest request) {
		Response response = null;
		try {
			Integer codetypeid = Integer.parseInt(request.getParameter("codetypeId"));
			List<Codevalue> Codevalue = commonService.getCodevalues(codetypeid);

			if (Codevalue.isEmpty()) {
				response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.RECORD_NOT_FOUND);
			} else {
				response = new Response(CommonConstants.NRG_SCUCESS, Codevalue, null);
			}
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

}
