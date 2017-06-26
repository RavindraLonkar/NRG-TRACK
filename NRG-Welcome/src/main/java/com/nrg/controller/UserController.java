package com.nrg.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.User;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@PostMapping("/save")
	private static void createEmployee()
	{
	    final String uri = "http://localhost:8080/NRG-APP/user/save";
	 
	    User user = new User();
	    user.setAge(22);
	    user.setFirstname("Namdev");
	    
	    RestTemplate restTemplate = new RestTemplate();
	    User result = restTemplate.postForObject( uri, user, User.class);
	 
	    System.out.println(result);
	}
}
