/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package com.nrg.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nrg.models.Email;
import com.nrg.utils.EmailService;


@Controller
@RequestMapping("/sending")
public class SendingController {

	@Autowired
	private EmailService emailService;

	/* Send HTML mail (simple) */
	@RequestMapping(value = "/sendMailSimple", method = POST)
	public String sendMail(@RequestParam("recipientName") final String recipientName,
			@RequestParam("recipientEmail") final String recipientEmail, final Locale locale)
			throws MessagingException {
		
		Email email = new Email();
		email.setTo("ravi.lonkar888@gmail.com");
		email.setFrom("ravindra.lonkar@extrapreneursindia.com");
		
		Map<String, Object> contextMap = new HashMap<String, Object>();
		contextMap.put("name", "Ravindra");
		contextMap.put("subscriptionDate", new Date());
		contextMap.put("hobbies", Arrays.asList("Cinema", "Sports", "Music"));
		
		email.setContextMap(contextMap);
		email.setSubject("Example HTML email (simple)");
		email.setTemplateUri("html/email-simple");
		
		try {
			this.emailService.sendMail(email, locale);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return "redirect:sent.html";

	}

}
