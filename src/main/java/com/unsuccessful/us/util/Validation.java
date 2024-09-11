package com.unsuccessful.us.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.unsuccessful.us.exception.InvalidRequestException;

public class Validation {

	public static void validatRequest(Object obj) {
		if (null == obj) {
			throw new InvalidRequestException();
		}
	}

	public static boolean isValidEmail(String email) {
		final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
		final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		if (email == null) {
			return false;
		}
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
