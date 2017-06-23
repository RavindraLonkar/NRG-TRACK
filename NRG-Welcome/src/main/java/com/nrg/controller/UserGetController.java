package com.nrg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserGetController {
	
    @GetMapping("/login")
    public String index() {
        return "login";
    }

}