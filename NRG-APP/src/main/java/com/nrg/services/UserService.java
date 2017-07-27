package com.nrg.services;

import com.nrg.models.User;
import com.nrg.utils.Response;

public interface UserService {
	public User findUserByusername(String username);
	public User session(String username);
	public User findUserByemailid(String email);
	public Response saveClient(User user);

}
