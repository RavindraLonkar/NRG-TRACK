package com.nrg.services;

import com.nrg.models.User;

public interface UserService {
	public User findUserByusername(String username);
	public User session(String username);
	public User findUserByemailid(String email);

}
