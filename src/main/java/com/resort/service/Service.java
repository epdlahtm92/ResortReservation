package com.resort.service;

import java.util.List;

import com.resort.domain.Notification;
import com.resort.domain.Reservation;
import com.resort.domain.Review;

public interface Service {
	
	interface ReservationListService {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation> readAllReservation();
	}
	
	interface NotificationService {
		// Create
			void createNewNotification(Notification notification); 
		
		// Read
			List<Notification> readAllNotification();
			
			Notification readOneNotificationById(int notificationId);
	}
	
	interface ReviewService {
		// Create
			void createOneReview(Review review);
		
		// Read
			List<Review> readAllReview();
	}
}
