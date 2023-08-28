package com.resort.service;

import java.util.List;

import com.resort.domain.Notification;
import com.resort.domain.Reply;
import com.resort.domain.Reservation;
import com.resort.domain.Review;

public interface Service {
	
	interface ReservationListService {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation> readAllReservation();
			
			Reservation readOneReservation(int reservationRoom, String reservationDate);
		
		// Update
		
		// Delete
			void deleteOneReservation(int reservationId);
	}
	
	interface NotificationService {
		// Create
			void createNewNotification(Notification notification); 
		
		// Read
			List<Notification> readAllNotification();
			
			Notification readOneNotificationById(int notificationId);
		
		// Delete
			void deleteOneNotification(int notificationId);
	}
	
	interface ReviewService {
		// Create
			void createOneReview(Review review);
		
		// Read
			List<Review> readAllReview();
		
		// Update
			
		// Delete
			void deleteOneReview(int reviewId);
	}
	
	interface ReplyService {
		// Create
			void createOneReply(Reply reply);
		
		// Read
			List<Reply> readAllReply(int rootId);
		
		// Delete
			void deleteOneReply(int replyId);
			
			void deleteAllReply(int rootId);
	}
}
