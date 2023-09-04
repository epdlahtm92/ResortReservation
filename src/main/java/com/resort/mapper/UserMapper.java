package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.security.CustomUserDetails;

@Mapper
public interface UserMapper {
	
	// Create
		void createOneUser(@Param("CustomUserDetails") CustomUserDetails customUserDetails);
	// Read
		List<String> readAllUsername();
	
		public CustomUserDetails getUserByUsername(@Param("userName") String username);
		
		List<CustomUserDetails> readAllUser();
	// Update
		void updateOneUser(@Param("CustomUserDetails") CustomUserDetails customUserDetails);
		
	// Delete
		void deleteOneUser(@Param("username") String username);
}
