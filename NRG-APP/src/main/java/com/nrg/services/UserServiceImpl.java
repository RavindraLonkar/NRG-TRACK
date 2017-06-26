package com.nrg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrg.models.User;
import com.nrg.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User findUserByusername(String username) {
		return userRepository.findUserByusername(username);
	}

}
