package com.nrg.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {

	public static String createPassword(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;

	}
}
