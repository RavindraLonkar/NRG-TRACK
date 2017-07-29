package com.nrg.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.Email;
import com.nrg.models.User;
import com.nrg.security.token.NRGToken;
import com.nrg.services.UserService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.EmailService;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	EmailService emailService;

	@Value("${CONFIRM_EMAIL_URL}")
	private String CONFIRM_EMAIL_URL;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	Response response = new Response();

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Response createNewUser(@RequestBody User user, final Locale locale) {
		User userResponse = new User();
		userResponse = userService.saveClient(user);
		if (userResponse != null) {
			String keyToEncrypt = user.getEmailid() + "|" + CommonUtils.getDate() + "|" + MATCH_USER_KEY;
			String confirmEmailToken = NRGToken.encrypt(keyToEncrypt, ENCY_USER_KEY);
			String confirmEmailURL = CONFIRM_EMAIL_URL + "?token=" + confirmEmailToken;

			Email email = new Email();
			email.setTo(userResponse.getEmailid());
			email.setFrom("ravindra.lonkar@extrapreneursindia.com");

			Map<String, Object> contextMap = new HashMap<String, Object>();
			contextMap.put("name", userResponse.getUsername());
			contextMap.put("confirmEmailLink", confirmEmailURL);

			email.setContextMap(contextMap);
			email.setSubject("Change Password Mail");
			email.setTemplateUri("mailTemplates/confirmEmailMail");

			try {
				this.emailService.sendMail(email, locale);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new Response(CommonConstants.NRG_SCUCESS, userResponse, CommonUserMessages.NRG_USER_SAVE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public User session(@RequestParam("username") String username) {
		return userService.session(username);
	}

	@RequestMapping(value = "/change/password", method = RequestMethod.POST)
	public Response changePassword(@RequestBody User user) {
		User userResponse = new User();
		userResponse = userService.updatePassword(user);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse,
					CommonUserMessages.USER_PASSWORD_UPDATE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}
	}
}
