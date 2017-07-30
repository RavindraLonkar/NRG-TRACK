package com.nrg.services;

import java.util.Locale;

import com.nrg.models.User;

public interface UserService {
	public User findUserByusername(String username);
	public User session(String username);
	public User findUserByemailid(String email);
	public User saveClient(User user,final Locale locale);
	public User updatePassword(User user);
	public User comfirmEmail(User user);

}
