package com.resort.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.mapper.UserMapper;


@Repository("userAuthDAO")
public class UserAuthDAO {
	
	@Autowired
	private UserMapper userMapper;
	// Create
		void createOneUser(CustomUserDetails customUserDetails) {
			userMapper.createOneUser(customUserDetails);
		}
	
	// Read
		List<String> readAllUsername() {
			return userMapper.readAllUsername();
		}
		
		//(login)
		public CustomUserDetails getUserByUsername(String username) {
			return userMapper.getUserByUsername(username);
		}
			
		List<CustomUserDetails> readAllUser(){
			return userMapper.readAllUser();
		}
		
	// Update
		void updateOneUser(CustomUserDetails customUserDetails) {
			userMapper.updateOneUser(customUserDetails);
		}
		
	// Delete
		void deleteOneUser(String username) {
			userMapper.deleteOneUser(username);
		}
}
