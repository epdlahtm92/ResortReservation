package com.resort.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.security.CustomUserDetails;

@Mapper
public interface UserMapper {
	
	// Create
	
	// Read
		public CustomUserDetails getUserByUserName(@Param("userName") String username);
	// Update
	
	// Delete
}
