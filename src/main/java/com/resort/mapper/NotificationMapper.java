package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.domain.Notification;

@Mapper
public interface NotificationMapper {
	
	// Create
		public int createNewNotification(@Param("Notification") Notification notification);
	
	// Read
		public List<Notification> readAllNotification();
		
	// Update
		void updateOneNotification(@Param("Notification") Notification notification);
		
	// Delete
		void deleteOneNotification(@Param("notificationId") int notificationId);
}
