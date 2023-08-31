	package com.resort.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ResortController {

	// Tab 1
		@GetMapping("/resortInfo")
		public String requestResortInfo() {
			return "resort/resortInfo";
		}
		
		@GetMapping("/room0Info")
		public String requestRoom0Info() {
			return "resort/room0Info";
		}
		
		@GetMapping("/room1Info")
		public String requestRoom1Info() {
			return "resort/room1Info";
		}
		
		@GetMapping("/room2Info")
		public String reqeustRoom2Info() {
			return "resort/room2Info";
		}
		
	// Tab 2
		@GetMapping("/mapInfo")
		public String requestMapInfo() {
			return "resort/mapInfo";
		}
	
	// Tab 3
		@GetMapping("/sight0Info")
		public String requestSight0Info() {
			return "resort/sight0Info";
		}
		
		@GetMapping("/sight1Info")
		public String requestSight1Info() {
			return "resort/sight1Info";
		}
	
		@GetMapping("/sight2Info")
		public String requestSight2Info() {
			return "resort/sight2Info";
		}
		
	// Tab 4
		@GetMapping("/adminPage")
		public String requestAdminPage() {
			return "security/adminPage";
		}
		
	////////////test
		@GetMapping("/subregi")
		public String subregi() {
			return "security/submitRegistration";
		}
		
}
