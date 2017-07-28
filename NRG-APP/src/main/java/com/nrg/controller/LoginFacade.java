package com.nrg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nrg.models.User;
import com.nrg.security.token.NRGToken;
import com.nrg.services.UserService;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
@RequestMapping("/service/login")
public class LoginFacade {

	@Autowired
	UserService userService;

	@Value("${CHANGE_PASSSWORD_URL}")
	private String CHANGE_PASSSWORD_URL;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	Response response = new Response();

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public User findUserByusername(@RequestBody User user) {

		return userService.findUserByusername(user.getUsername());

	}

	@RequestMapping(value = "/email", method = RequestMethod.POST)
	public Response findUserByemailid(@RequestBody User user) {
		User UserDataForEmail = new User();
		UserDataForEmail = userService.findUserByemailid(user.getEmailid());
		if (UserDataForEmail == null) {
			response = new Response(CommonConstants.NRG_FAIL, null, CommonUserMessages.NRG_USER_NOT_FOUND);
		} else {
			String changePasswordToken = NRGToken.encrypt(CHANGE_PASSSWORD_URL, ENCY_USER_KEY);
			String changePasswordURL = CHANGE_PASSSWORD_URL + "?token=" + changePasswordToken;

			response = new Response(CommonConstants.NRG_SCUCESS, UserDataForEmail,
					CommonUserMessages.NRG_USER_FOUND_CONFIRMATION_EMAIL_MSG);
		}
		return response;
	}
}
