package com.resort.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.mapper.UserMapper;


@Repository("userAuthDAO")
public class UserAuthDAO {
	
	@Autowired
	private UserMapper userMapper;
	
	// Read (login)
		public CustomUserDetails getUserByUserName(String username) {
			return userMapper.getUserByUserName(username);
		}
}
