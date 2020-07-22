package com.tutorial.login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("Jinal") && password.equals("jin123")) {
			return true;
		}
		return false;
	}
}
