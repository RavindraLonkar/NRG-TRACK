package com.nrg.services;

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
	public Response saveClient(User user) {
		User userResponse = new User();
		Role userRole = new Role();
		String encryptPassword = CommonUtils.createPassword(user.getPassword());
		userRole=roleRepository.findByrolename(CommonUserMessages.NRG_USER_ROLE);
		user.setRole(userRole);
		user.setIsactive(CommonConstants.NRG_ISACTIVE);
		user.setUsername(user.getEmailid());
		user.setPassword(encryptPassword);
		userResponse = userRepository.save(user);
		if (userResponse != null) {
			return new Response(CommonConstants.NRG_SCUCESS, userResponse, CommonUserMessages.NRG_USER_SAVE_SUCCESS);
		} else {
			return new Response(CommonConstants.NRG_FAIL, null, "");
		}

	}

}
