package com.resort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.domain.Reservation;
import com.resort.repository.Repository;
import com.resort.service.Service.ReservationListService;

@Service
public class ReservationListServiceImpl implements ReservationListService {

	@Autowired
	private Repository.ReservationListRepository reservationRepository;
	
	// Create
		@Override
		public void createOneReservation(Reservation reservation) {
			reservationRepository.createOneReservation(reservation);
		}
		
	// Read
		@Override
		public List<Reservation> readAllReservation() {
			return reservationRepository.readAllReservation();
		}

		@Override
		public Reservation readOneReservation(int reservationRoom, String reservationDate) {
			return reservationRepository.readOneReservation(reservationRoom, reservationDate);
		}
	
	// Update
		@Override
		public void updateOneReservation(Reservation reservation) {
			reservationRepository.updateOneReservation(reservation);
		}
		
	// Delete
		@Override
		public void deleteOneReservation(int reservationId) {
			reservationRepository.deleteOneReservation(reservationId);
		}

		

}
