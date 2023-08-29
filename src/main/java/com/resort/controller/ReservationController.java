package com.resort.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.domain.Reservation;
import com.resort.domain.RoomStatus;
import com.resort.service.Service;

@Controller
public class ReservationController {
	@Autowired
	private Service.ReservationListService reservationService;
	
	private List<Reservation> listofReservation;
	
	// Create
		@GetMapping("/newReservation")
		public String requestNewReservation(@RequestParam("reservationDate") String reservationDate, @RequestParam("reservationRoom") int reservationRoom, Model model) {
			Reservation reservation = new Reservation();
			reservation.setReservationDate(reservationDate);
			reservation.setReservationRoom(reservationRoom);
			model.addAttribute("newReservation", reservation);
			model.addAttribute("newReservationTitle", "예약하기");
	
			return "reservation/newReservation";
		}
		
		@PostMapping("/newReservation")
		public String submitNewReservation(@ModelAttribute("newReservation") Reservation reservation, Model model) {
			reservationService.createOneReservation(reservation);
			return "redirect:/reservationList";
		}
		
	
	// Read
		@GetMapping("/reservationList")
		public String requestReservationList(Model model) {
			LocalDate today = LocalDate.now();
			listofReservation = reservationService.readAllReservation();
			List<RoomStatus> roomStatusList = new ArrayList<RoomStatus>();
	
			for (int i = 0; i < 31; i++) {
				RoomStatus roomStatus = new RoomStatus("0", "0", "0");
				roomStatus.setReservationDate(today.plusDays(i).toString());
				
				roomStatusList.add(roomStatus);
			}
			
			for (RoomStatus roomStatus : roomStatusList) {
				for (Reservation reservation : listofReservation) {
					if (roomStatus.getReservationDate().equals(reservation.getReservationDate())) {
						if(reservation.getReservationRoom() == 0) {
							roomStatus.setRoom0Status(reservation.getName());
						} else if (reservation.getReservationRoom() == 1) {
							roomStatus.setRoom1Status(reservation.getName());
						} else if (reservation.getReservationRoom() == 2) {
							roomStatus.setRoom2Status(reservation.getName());
						}
						
					}
				}
				
			}
			
			model.addAttribute("roomStatusList", roomStatusList);
			
			return "reservation/reservationList";
		}
		
		@GetMapping("/reservation")
		public String requestOneReservation(@RequestParam("reservationRoom") int reservationRoom, @RequestParam("reservationDate") String reservationDate, Model model) {
			Reservation reservation = reservationService.readOneReservation(reservationRoom, reservationDate);
			model.addAttribute("reservation", reservation);
			return "reservation/reservation";
		}
		
	
	// Update
		@GetMapping("/updateOneReservation")
		public String requestUpdateOneReservation(@RequestParam("reservationRoom") int reservationRoom, @RequestParam("reservationDate") String reservationDate, Model model) {
			Reservation reservation = reservationService.readOneReservation(reservationRoom, reservationDate);
			model.addAttribute("updateReservation", reservation);
			return "reservation/updateReservation";
		}
		
		@PostMapping("/updateOneReservation")
		public String submitUpdateOneReservation(@ModelAttribute("updateReservation") Reservation reservation) {
			reservationService.updateOneReservation(reservation);
			int reservationRoom = reservation.getReservationRoom();
			String reservationDate = reservation.getReservationDate();
			return "redirect:/reservation?reservationRoom=" + reservationRoom + "&reservationDate=" + reservationDate;
		}
		
	// Delete
		@GetMapping("/deleteOneReservation")
		public String requestDeleteOneReservation(@RequestParam("reservationId") int reservationId) {
			reservationService.deleteOneReservation(reservationId);
			return "redirect:/reservationList";
		}
		
}
