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
			void updateOneReservation(Reservation reservation);
			
		// Delete
			void deleteOneReservation(int reservationId);
	}
	
	interface NotificationService {
		// Create
			int createNewNotification(Notification notification); 
		
		// Read
			List<Notification> readAllNotification();
			
			Notification readOneNotificationById(int notificationId);
		
		// Update
			void updateOneNotification(Notification notification);
			
		// Delete
			void deleteOneNotification(int notificationId);
	}
	
	interface ReviewService {
		// Create
			void createOneReview(Review review);
		
		// Read
			List<Review> readAllReview();
			
			Review readOneReviewById(int reviewId);
		
		// Update
			void updateOneReview(Review review);
			
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
