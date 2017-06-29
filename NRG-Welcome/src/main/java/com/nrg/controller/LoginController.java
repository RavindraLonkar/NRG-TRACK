package com.nrg.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nrg.models.User;

@RestController
public class LoginController {
	
	@Value("${REDIRECT_USER_URL}")
	private String REDIRECT_USER_URL;
	
	@Value("${REDIRECT_ADMIN_URL}")
	private String REDIRECT_ADMIN_URL;
	
	@Value("${USER_NAME_KEY}")
	private String USER_NAME_KEY;
	
	
	
	
	

	@RequestMapping(value={"/", "/login.htm"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		String url="";
		RestTemplate rest=new RestTemplate();
		User userExists = rest.postForObject(url, user, User.class);
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			//userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value="/login/sucessfull", method = RequestMethod.GET)
	public ModelAndView loginSucessfull(HttpRequest req){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String usernName=((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
		String url=determineTargetUrl(auth);
		return new ModelAndView("redirect:"+url+"?userName="+usernName);
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

