package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.CodeType;
import com.nrg.models.User;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/common")
public class CommonController {

	@Value("${GET_CODE_VALUES}")
	private String GET_CODE_VALUES;

	Response response = null;

	@RequestMapping(value = "/codevalue", method = RequestMethod.GET)
	public Response profileSave(HttpServletRequest request) {
		RestTemplate rest = new RestTemplate();
		int codetypeid = Integer.parseInt(request.getParameter("codetypeId"));
		Response response = null;
		try {
			String codevalueIdsUrl = GET_CODE_VALUES + "?codetypeId=" + codetypeid;
			response = rest.getForObject(codevalueIdsUrl, Response.class);
		} catch (Exception e) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.SYSTEM_ERROR);
		}

		return response;
	}

}
