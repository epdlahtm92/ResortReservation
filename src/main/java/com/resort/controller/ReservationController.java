package com.resort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.domain.Reservation;
import com.resort.service.Service;

@Controller
public class ReservationController {
	@Autowired
	private Service.ReservationListService reservationService;
	
	private List<Reservation> listofReservation;
	
	// Create
	
	// Read
	
	// Update
		@GetMapping("/updateOneReservation")
		public String requestUpdateOneReservation(@RequestParam("reservationRoom") int reservationRoom, @RequestParam("reservationDate") String reservationDate, Model model) {
			Reservation reservation = reservationService.readOneReservation(reservationRoom, reservationDate);
			model.addAttribute("updateReservation", reservation);
			return "updateReservation";
		}
		
		@PostMapping("/updateOneReservation")
		public String submitUpdateOneReservation(@ModelAttribute("updateReservation") Reservation reservation) {
			reservationService.updateOneReservation(reservation);
			int reservationRoom = reservation.getReservationRoom();
			String reservationDate = reservation.getReservationDate();
			return "redirect:/reservation?reservationRoom=" + reservationRoom + "&reservationDate=" + reservationDate;
		}
		
	// Delete

}
