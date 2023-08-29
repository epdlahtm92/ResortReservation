package com.resort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.domain.Notification;
import com.resort.repository.Repository;
import com.resort.service.Service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Autowired
	private Repository.NotificationRepository notificationRepository;
	
	// Create
		@Override
		public void createNewNotification(Notification notification) {
			notificationRepository.createNewNotification(notification);
		}
		
	// Read
		@Override
		public List<Notification> readAllNotification() {
			return notificationRepository.readAllNotification();
		}
	
		@Override
		public Notification readOneNotificationById(int notificationId) {
			return notificationRepository.readOneNotificationById(notificationId);
		}
	
	// Update
		@Override
		public void updateOneNotification(Notification notification) {
			notificationRepository.updateOneNotification(notification);
		}
		
	// Delete
		@Override
		public void deleteOneNotification(int notificationId) {
			notificationRepository.deleteOneNotification(notificationId);
		}

		

}
