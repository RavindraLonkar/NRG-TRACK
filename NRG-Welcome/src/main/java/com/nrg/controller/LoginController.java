package com.nrg.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nrg.models.User;
import com.nrg.security.token.NRGToken;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.Response;

@RestController
public class LoginController {

	@Value("${REDIRECT_USER_URL}")
	private String REDIRECT_USER_URL;

	@Value("${REDIRECT_ADMIN_URL}")
	private String REDIRECT_ADMIN_URL;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${FIND_USER_BY_EMAIL}")
	private String FIND_USER_BY_EMAIL;

	@Value("${SAVE_CLIENT}")
	private String SAVE_CLIENT;

	Response response = new Response();

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	@ResponseBody
	public Response createNewUser(@RequestBody User user) {
		RestTemplate rest = new RestTemplate();
		String url = FIND_USER_BY_EMAIL;
		try {
			response = rest.postForObject(url, user, Response.class);
			if (response.getStatus().equals(CommonConstants.NRG_SCUCESS)) {
				return response = new Response(CommonConstants.NRG_USER_EXISTS, null,
						CommonUserMessages.NRG_USER_FOUND_ENTER_DIFF_EMAIL);
			} else {
				String saveUrl = SAVE_CLIENT;
				response = rest.postForObject(saveUrl, user, Response.class);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return response;

	}

	@RequestMapping(value = "/login/sucessfull", method = RequestMethod.GET)
	public ModelAndView loginSucessfull(HttpRequest req) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usernName = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
		String encryptkey = NRGToken.encrypt(usernName + "|" + MATCH_USER_KEY, ENCY_USER_KEY);
		String url = determineTargetUrl(auth);
		return new ModelAndView("redirect:" + url + "?userName=" + encryptkey);
	}

	protected String determineTargetUrl(Authentication authentication) {
		boolean isAdmin = false;
		boolean isUser = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				isAdmin = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("USER")) {
				isUser = true;
				break;
			}
		}

		if (isAdmin) {
			return REDIRECT_ADMIN_URL;
		} else if (isUser) {
			return REDIRECT_USER_URL;
		} else {
			throw new IllegalStateException();
		}
	}

}
