package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.domain.Reservation;

@Mapper
public interface ReservationListMapper {
	
	// Create
		void createOneReservation(@Param("Reservation") Reservation reservation);
		
	// Read
		List<Reservation> readAllReservation();
	
	// Update
		
	// Delete
		void deleteOneReservation(@Param("reservationId") int reservationId);
}
