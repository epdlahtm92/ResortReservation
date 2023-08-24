package com.resort.repository;

import java.util.List;

import com.resort.domain.Notification;
import com.resort.domain.Reservation;
import com.resort.domain.Review;

public interface Repository {
	
	interface ReservationListRepository {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation>readAllReservation();
	}
	
	interface NotificationRepository {
		// Create
			void createNewNotification(Notification notification);
			
		// Read
			List<Notification>readAllNotification();
			
			Notification readOneNotificationById(int notificationId);
	}
	
	interface ReviewRepository {
		
		// Create
			void createOneReview(Review review);
		
		// Read
			List<Review>readAllReview();
	}
}
