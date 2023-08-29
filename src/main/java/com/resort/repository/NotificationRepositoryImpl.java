package com.resort.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.domain.Notification;
import com.resort.mapper.NotificationMapper;
import com.resort.repository.Repository.NotificationRepository;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

	@Autowired
	private NotificationMapper notificationMapper;
	
	private List<Notification> listofNotification;
	
	// Create
		@Override
		public void createNewNotification(Notification notification) {
			notificationMapper.createNewNotification(notification);
		}
		
	// Read
		@Override
		public List<Notification> readAllNotification() {
			listofNotification = notificationMapper.readAllNotification();
			return listofNotification;
		}
	
		@Override
		public Notification readOneNotificationById(int notificationId) {
			Notification notificationById = null;
			listofNotification = notificationMapper.readAllNotification();
			for (Notification notification : listofNotification) {
				if (notificationId == notification.getNotificationId()) {
					notificationById = notification;
				}
			}

			return notificationById;
		}
	
	// Update
		@Override
		public void updateOneNotification(Notification notification) {
			notificationMapper.updateOneNotification(notification);
		}
	
	// Delete
		@Override
		public void deleteOneNotification(int notificationId) {
			notificationMapper.deleteOneNotification(notificationId);
		}

		

		

}
