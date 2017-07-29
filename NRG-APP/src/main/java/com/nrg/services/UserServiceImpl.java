package com.nrg.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Role;
import com.nrg.models.User;
import com.nrg.repositories.RoleRepository;
import com.nrg.repositories.UserRepository;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUserMessages;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.Response;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;


	Response response = new Response();

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
	public User saveClient(User user) {
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

}
