package com.nrg.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nrg.models.TXN_User;

@RestController
@RequestMapping("/user")
public class UserController {
		
	@PostMapping("/save")
	private static void createEmployee()
	{
	    final String uri = "http://localhost:8080/NRG-APP/user/save";
	 
	    TXN_User tXN_User = new TXN_User();
	    tXN_User.setAge(22);
	    tXN_User.setFirstName("Namdev");
	    
	    RestTemplate restTemplate = new RestTemplate();
	    TXN_User result = restTemplate.postForObject( uri, tXN_User, TXN_User.class);
	 
	    System.out.println(result);
	}
}
