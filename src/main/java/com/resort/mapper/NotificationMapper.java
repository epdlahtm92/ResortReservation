package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.domain.Notification;

@Mapper
public interface NotificationMapper {
	
	// Create
		void createNewNotification(@Param("Notification") Notification notification);
	
	// Read
		public List<Notification> readAllNotification();
}
