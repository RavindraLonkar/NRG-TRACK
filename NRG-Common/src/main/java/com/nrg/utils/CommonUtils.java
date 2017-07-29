package com.nrg.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CommonUtils {

	public static String createPassword(String password) {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;

	}

	public static String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String toDate = format.format(new Date());
		return toDate;
	}

	public static boolean validatedTokenForTimePeriod(String Sendtime, String validationTime) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date sendDate = null;
		Date currentDate = null;
		try {
			sendDate = format.parse(Sendtime);
			currentDate = format.parse(CommonUtils.getDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		long diff = currentDate.getTime()-sendDate.getTime();
		long diffHours = diff / (60 * 60 * 1000);
		if (diffHours < Integer.parseInt(validationTime)) {
			return true;
		}
		return false;

	}
}
