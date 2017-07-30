package com.nrg.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nrg.models.Email;
import com.nrg.models.Role;
import com.nrg.models.User;
import com.nrg.repositories.RoleRepository;
import com.nrg.repositories.UserRepository;
import com.nrg.security.token.NRGToken;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.EmailService;
import com.nrg.utils.Response;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	EmailService emailService;

	@Value("${FROM_EMAIL_ID}")
	private String FROM_EMAIL_ID;

	@Value("${CONFIRM_EMAIL_SUBJECT}")
	private String CONFIRM_EMAIL_SUBJECT;

	@Value("${CONFIRM_EMAIL_TEMPLATE}")
	private String CONFIRM_EMAIL_TEMPLATE;

	@Value("${CONFIRM_EMAIL_URL}")
	private String CONFIRM_EMAIL_URL;

	@Value("${ENCY_USER_KEY}")
	private String ENCY_USER_KEY;

	@Value("${MATCH_USER_KEY}")
	private String MATCH_USER_KEY;

	Response response = null;

	@Override
	public User findUserByusername(String username) {
		return userRepository.findUserByusername(username);
	}

	@Override
	public User session(String username) {
		return userRepository.findAllByusername(username);
	}

	@Override
	public User findUserByemailid(String email) {
		return userRepository.findUserByemailid(email);
	}

	@Override
	public User saveClient(User user, final Locale locale) {
		User userResponse = new User();
		Role userRole = new Role();
		String encryptPassword = CommonUtils.createPassword(user.getPassword());
		userRole = roleRepository.findByrolename(CommonUserMessages.NRG_USER_ROLE);
		user.setRole(userRole);
		user.setIsactive(CommonConstants.NRG_ISACTIVE);
		user.setUsername(user.getEmailid());
		user.setPassword(encryptPassword);
		user.setCreatedby(1);
		user.setLastmodifiedby(1);
		user.setCreateddate(new Date());
		user.setLastmodifieddate(new Date());
		user.setIsemailidconfirmed(0);
		userResponse = userRepository.save(user);
		if (userResponse != null) {
			String keyToEncrypt = user.getUserid() + "|" + CommonUtils.getDate() + "|" + MATCH_USER_KEY;
			String confirmEmailToken = NRGToken.encrypt(keyToEncrypt, ENCY_USER_KEY);
			String confirmEmailURL = CONFIRM_EMAIL_URL + "?token=" + confirmEmailToken;

			Email email = new Email();
			email.setTo(userResponse.getEmailid());
			email.setFrom(FROM_EMAIL_ID);
			Map<String, Object> contextMap = new HashMap<String, Object>();
			contextMap.put("name", userResponse.getUsername());
			contextMap.put("confirmEmailLink", confirmEmailURL);
			email.setContextMap(contextMap);
			email.setSubject(CONFIRM_EMAIL_SUBJECT);
			email.setTemplateUri(CONFIRM_EMAIL_TEMPLATE);
			try {
				this.emailService.sendMail(email, locale);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userResponse;

	}

	@Override
	public User updatePassword(User user) {
		Role userRole = new Role();
		userRole = roleRepository.findByrolename(CommonUserMessages.NRG_USER_ROLE);
		user.setRole(userRole);
		User userResponse = new User();
		userResponse = userRepository.findUserByuserid(user.getUserid());
		userResponse.setPassword(user.getPassword());
		userResponse.setLastmodifieddate(new Date());
		return userResponse = userRepository.save(userResponse);
	}

	@Override
	public User comfirmEmail(User user) {
		Role userRole = new Role();
		userRole = roleRepository.findByrolename(CommonUserMessages.NRG_USER_ROLE);
		user.setRole(userRole);
		User userResponse = new User();
		userResponse = userRepository.findUserByuserid(user.getUserid());
		userResponse.setIsemailidconfirmed(1);
		userResponse.setLastmodifieddate(new Date());
		return userResponse = userRepository.save(userResponse);
	}

}
