package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.security.token.NRGToken;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.Response;

@RestController
public class ConfirmEmailController {

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${TOKEN_VALIDATION_TIME_IN_HRS}")
	private String TOKEN_VALIDATION_TIME_IN_HRS;

	@Value("${CONFIRM_USER_EMAIL}")
	private String CONFIRM_USER_EMAIL;

	Response response = null;

	@RequestMapping(value = { "/confirmemail" }, method = RequestMethod.GET)
	public ModelAndView changePassword(HttpServletRequest request) {
		RestTemplate rs = new RestTemplate();
		User userData = new User();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("confirmemailerror");
		try {
			String token = request.getParameter("token").replace(' ', '+');
			String decryKey = NRGToken.decrypt(token, ENCY_USER_KEY);
			if (decryKey != null && decryKey.contains(MATCH_USER_KEY)) {
				String tokensendTime = decryKey.split("\\|")[1];
				boolean valid = CommonUtils.validatedTokenForTimePeriod(tokensendTime, TOKEN_VALIDATION_TIME_IN_HRS);
				if (valid == true) {
					int userId = Integer.parseInt(decryKey.split("\\|")[0]);
					userData.setUserid(userId);
					String url = CONFIRM_USER_EMAIL;
					response = rs.postForObject(url, userData, Response.class);
					if (response.getStatus().equals(CommonConstants.NRG_SCUCESS)) {
						modelAndView.addObject("success", response.getResonCode());
					} else {
						modelAndView.addObject("error", CommonUserMessages.CONFIRM_EMAIL_FAIL);
					}
				} else {
					modelAndView.addObject("error", CommonUserMessages.CONFIRM_EMAIL_TOKEN_INVALID);
				}

			} else {
				modelAndView.addObject("error", CommonUserMessages.CONFIRM_EMAIL_TOKEN_INVALID);
			}

		} catch (Exception e) {
			modelAndView.addObject("error", CommonUserMessages.SYSTEM_ERROR);
		}

		return modelAndView;
	}

}
