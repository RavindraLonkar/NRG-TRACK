package com.nrg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.Role;
import com.nrg.models.User;
import com.nrg.repositories.UserRepository;
import com.nrg.utils.CommonConstants;
import com.nrg.utils.CommonUtils;
import com.nrg.utils.Response;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

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
	public Response saveClient(User user) {
		Role userRole=new Role();
		String encryptPassword=CommonUtils.createPassword(user.getPassword());
		user.setIsactive(CommonConstants.NRG_ISACTIVE);
		user.setUsername(user.getUsername());
		user.setPassword(encryptPassword);
		userRole.setRoleid(CommonConstants.NRG_USER_ROLE);
		user.setRole(userRole);
		userRepository.save(user);
		return null;
	}

}
