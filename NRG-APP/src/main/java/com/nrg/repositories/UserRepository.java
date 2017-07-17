package com.nrg.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nrg.models.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	 User findUserByusername(String username);
	 User findAllByusername(String username);
	 
}