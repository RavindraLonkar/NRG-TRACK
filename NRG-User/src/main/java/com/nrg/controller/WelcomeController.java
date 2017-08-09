/**
 * 
 */
package com.nrg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;
import com.nrg.security.token.NRGToken;

/**
 * @author Namdev
 *
 */
@RestController
public class WelcomeController {

	@Value("${USER_SESSION_DATA}")
	private String USER_SESSION_DATA;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${LOGIN_URL}")
	private String LOGIN_URL;

	@RequestMapping(value = "/build/session", method = RequestMethod.GET)
	public ModelAndView buildsession(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = request.getParameter("userName").replace(' ', '+');
			String decryKey = NRGToken.decrypt(userName, ENCY_USER_KEY);
			HttpSession session = request.getSession();
			if (decryKey != null && decryKey.contains(MATCH_USER_KEY)) {
				String decryUser=decryKey.split("\\|")[0];
				session.setAttribute("username", decryUser);
				RestTemplate restTemplate = new RestTemplate();
				String sessionurl = USER_SESSION_DATA + "?username=" + decryUser;
				User result = restTemplate.getForObject(sessionurl, User.class);
				//request.getSession().setAttribute("usersession", result);
				session.setAttribute("usersession", result);
			} else {
				session.invalidate();
				response.sendRedirect(LOGIN_URL);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return new ModelAndView("redirect:" + "/home");
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loadHome() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("index");
		return modelAndView;
	}

}
