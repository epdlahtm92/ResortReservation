package com.resort.repository;

import java.util.List;

import com.resort.domain.Reservation;

public interface Repository {
	
	interface ReservationListRepository {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation> readAllReservation();
	}
}
