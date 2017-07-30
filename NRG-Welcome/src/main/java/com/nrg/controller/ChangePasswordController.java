package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.Token;
import com.nrg.models.User;
import com.nrg.security.token.NRGToken;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.Response;

@RestController
public class ChangePasswordController {

	@Value("${UPDATE_USER_PASSWORD}")
	private String UPDATE_USER_PASSWORD;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${TOKEN_VALIDATION_TIME_IN_HRS}")
	private String TOKEN_VALIDATION_TIME_IN_HRS;

	Response response = null;

	@RequestMapping(value = { "/changepassword" }, method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();

		String token = request.getParameter("token").replace(' ', '+');
		String decryKey = NRGToken.decrypt(token, ENCY_USER_KEY);
		if (decryKey != null && decryKey.contains(MATCH_USER_KEY)) {
			String tokensendTime = decryKey.split("\\|")[1];
			boolean valid = CommonUtils.validatedTokenForTimePeriod(tokensendTime, TOKEN_VALIDATION_TIME_IN_HRS);
			if (valid == true) {
				modelAndView.setViewName("changepassword");
			} else {
				modelAndView.setViewName("changepassworderror");
				modelAndView.addObject("error", CommonUserMessages.CONFIRM_EMAIL_TOKEN_EXPIRE);
			}

		} else {
			modelAndView.setViewName("changepassworderror");
			modelAndView.addObject("error", CommonUserMessages.CONFIRM_EMAIL_TOKEN_INVALID);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public Response changePassword(@RequestBody Token token) {
		RestTemplate rs = new RestTemplate();
		User userData = new User();
		try {
			String encryToken = token.getToken();
			String encrypassword = CommonUtils.createPassword(token.getPassword());
			String decryKey = NRGToken.decrypt(encryToken, ENCY_USER_KEY);
			int userId = Integer.parseInt(decryKey.split("\\|")[0]);
			userData.setPassword(encrypassword);
			userData.setUserid(userId);
			String url = UPDATE_USER_PASSWORD;
			response = rs.postForObject(url, userData, Response.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return response;
	}

}
