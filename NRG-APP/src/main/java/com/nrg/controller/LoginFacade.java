package com.nrg.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/service/login")
public class LoginFacade {

	@Autowired
	UserService userService;

	@Autowired
	EmailService emailService;

	@Value("${CHANGE_PASSSWORD_URL}")
	private String CHANGE_PASSSWORD_URL;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;
	Response response = new Response();

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User findUserByusername(@RequestBody User user) {

		return userService.findUserByusername(user.getUsername());

	}

	@RequestMapping(value = "/Email", method = RequestMethod.POST)
	public Response findUserByEmailidForRegistration(@RequestBody User user, final Locale locale) {
		User userDataForEmail = new User();
		userDataForEmail = userService.findUserByemailid(user.getEmailid());
		if (userDataForEmail != null) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.NRG_USER_FOUND_ENTER_DIFF_EMAIL);
		} else {

			response = new Response(CommonConstants.NRG_SCUCESS, userDataForEmail,
					CommonUserMessages.NRG_USER_NOT_FOUND);
		}
		return response;
	}

	@RequestMapping(value = "/passwordRequestEmail", method = RequestMethod.POST)
	public Response findUserByemailid(@RequestBody User user, final Locale locale) {
		User userDataForEmail = new User();
		userDataForEmail = userService.findUserByemailid(user.getEmailid());
		if (userDataForEmail == null) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.NRG_USER_NOT_FOUND);
		} else {
			String keyToEncrypt = userDataForEmail.getUserid() + "|" + CommonUtils.getDate() + "|" + MATCH_USER_KEY;
			String changePasswordToken = NRGToken.encrypt(keyToEncrypt, ENCY_USER_KEY);
			String changePasswordURL = CHANGE_PASSSWORD_URL + "?token=" + changePasswordToken;

			Email email = new Email();
			email.setTo(userDataForEmail.getEmailid());
			email.setFrom("ravindra.lonkar@extrapreneursindia.com");

			Map<String, Object> contextMap = new HashMap<String, Object>();
			contextMap.put("name", userDataForEmail.getUsername());
			contextMap.put("changePasswordLink", changePasswordURL);

			email.setContextMap(contextMap);
			email.setSubject("Change Password Mail");
			email.setTemplateUri("mailTemplates/forgotPasswordMail");

			try {
				this.emailService.sendMail(email, locale);
			} catch (Exception e) {
				e.printStackTrace();
			}

			response = new Response(CommonConstants.NRG_SCUCESS, userDataForEmail,
					CommonUserMessages.NRG_USER_FOUND_CONFIRMATION_EMAIL_MSG);
		}
		return response;
	}
	
}
