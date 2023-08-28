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
public class ResortController {

	@Autowired
	private Service.ReservationListService reservationService;
	
	private List<Reservation> listofReservation;
	
	// Tab 1
		@GetMapping("/resortInfo")
		public String requestResortInfo() {
			return "resortInfo";
		}
		
		@GetMapping("/room0Info")
		public String requestRoom0Info() {
			return "room0Info";
		}
		
		@GetMapping("/room1Info")
		public String requestRoom1Info() {
			return "room1Info";
		}
		
		@GetMapping("/room2Info")
		public String reqeustRoom2Info() {
			return "room2Info";
		}
		
	// Tab 2
		@GetMapping("/mapInfo")
		public String requestMapInfo() {
			return "mapInfo";
		}
	
	// Tab 3
		@GetMapping("/sight0Info")
		public String requestSight0Info() {
			return "sight0Info";
		}
		
		@GetMapping("/sight1Info")
		public String requestSight1Info() {
			return "sight1Info";
		}
	
		@GetMapping("/sight2Info")
		public String requestSight2Info() {
			return "sight2Info";
		}
		
	// Tab 4
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
			
			return "reservationList";
		}
		@GetMapping("/reservation")
		public String requestOneReservation(@RequestParam("reservationRoom") int reservationRoom, @RequestParam("reservationDate") String reservationDate, Model model) {
			Reservation reservation = reservationService.readOneReservation(reservationRoom, reservationDate);
			model.addAttribute("reservation", reservation);
			return "reservation";
		}
		
		
		@GetMapping("/newReservation")
		public String requestNewReservation(@RequestParam("reservationDate") String reservationDate, @RequestParam("reservationRoom") int reservationRoom, Model model) {
			Reservation reservation = new Reservation();
			reservation.setReservationDate(reservationDate);
			reservation.setReservationRoom(reservationRoom);
			model.addAttribute("newReservation", reservation);
			model.addAttribute("newReservationTitle", "예약하기");
	
			return "newReservation";
		}
		
		@PostMapping("/newReservation")
		public String submitNewReservation(@ModelAttribute("newReservation") Reservation reservation, Model model) {
			reservationService.createOneReservation(reservation);
			return "redirect:/reservationList";
		}
		
		@GetMapping("/deleteOneReservation")
		public String requestDeleteOneReservation(@RequestParam("reservationId") int reservationId) {
			reservationService.deleteOneReservation(reservationId);
			return "redirect:/reservationList";
		}
		
		
		@GetMapping("/adminPage")
		public String requestAdminPage() {
			return "adminPage";
		}
		

		
}
