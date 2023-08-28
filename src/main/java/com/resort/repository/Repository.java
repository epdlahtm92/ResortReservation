package com.resort.repository;

import java.util.List;

import com.resort.domain.Notification;
import com.resort.domain.Reply;
import com.resort.domain.Reservation;
import com.resort.domain.Review;

public interface Repository {
	
	interface ReservationListRepository {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation> readAllReservation();
			
			Reservation readOneReservation(int reservationRoom, String reservationDate);
		
		// Update
			
		// Delete
			void deleteOneReservation(int reservationId);
	}
	
	interface NotificationRepository {
		// Create
			void createNewNotification(Notification notification);
			
		// Read
			List<Notification> readAllNotification();
			
			Notification readOneNotificationById(int notificationId);
		
		// Update
		
		// Delete
			void deleteOneNotification(int notificationId);
	}
	
	interface ReviewRepository {
		
		// Create
			void createOneReview(Review review);
		
		// Read
			List<Review>readAllReview();
		
		// Update
			
		// Delete
			void deleteOneReview(int reviewId);
	}
	
	interface ReplyRepository {
		
		// Create
			void createOneReply(Reply reply);
			
		// Read
			List<Reply> readAllReply(int rootId);
			
		// Delete
			void deleteOneReply(int replyId);
			
			void deleteAllReply(int rootId);
			
	}
}
