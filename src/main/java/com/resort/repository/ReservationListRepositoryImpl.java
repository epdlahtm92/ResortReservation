package com.resort.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.domain.Reservation;
import com.resort.mapper.ReservationListMapper;
import com.resort.repository.Repository.ReservationListRepository;

@Repository
public class ReservationListRepositoryImpl implements ReservationListRepository {

	@Autowired
	private ReservationListMapper reservationListMapper;
	
	private List<Reservation> listofReservation;
	
	// Create
		@Override
		public void createOneReservation(Reservation reservation) {
			reservationListMapper.createOneReservation(reservation);
			System.out.println("확인 : " + reservation.getReservationDate());
		}

	// Read
		@Override
		public List<Reservation> readAllReservation() {
			listofReservation = reservationListMapper.readAllReservation();
			return listofReservation;
		}
}
