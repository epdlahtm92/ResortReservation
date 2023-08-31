package com.resort.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserAuthDAO userAuthDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// Create
		public void createOneUser(CustomUserDetails customUserDetails) {
			String rawPassword = customUserDetails.getPassword();
			customUserDetails.setPassword(passwordEncoder.encode(rawPassword));
			userAuthDAO.createOneUser(customUserDetails);
		}
	
	
	// Read
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			CustomUserDetails user = userAuthDAO.getUserByUsername(username);
			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			return user;
		}
		
		public List<String> readAllUsername() {
			return userAuthDAO.readAllUsername();
		}

}
