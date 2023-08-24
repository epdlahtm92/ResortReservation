package com.resort.service;

import java.util.List;

import com.resort.domain.Reservation;

public interface Service {
	
	interface ReservationListService {
		// Create
			void createOneReservation(Reservation reservation);
		
		// Read
			List<Reservation> readAllReservation();
	}
}
