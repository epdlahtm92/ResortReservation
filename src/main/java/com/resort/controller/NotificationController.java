package com.resort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.domain.Notification;
import com.resort.service.Service;

@Controller
public class NotificationController {

	@Autowired
	private Service.NotificationService notificationSerivce;
	
	private List<Notification> listofNotification;
	
	// Create
		@GetMapping("/newNotification")
		public String requestNewNotification(@ModelAttribute("newNotification") Notification notification) {
			return "newNotification";
		}
		
		@PostMapping("/newNotification") 
		public String submitNewNotification(@ModelAttribute("newNotification") Notification notification) {
			notificationSerivce.createNewNotification(notification);
			return "redirect:/notificationList";
		}
	
	// Read
		@GetMapping("/notificationList")
		public String requestNotificationList(Model model) {
			
			listofNotification = notificationSerivce.readAllNotification();
			
			model.addAttribute("notificationList", listofNotification);
			
			return "notificationList";
		}
		
		@GetMapping("/notification")
		public String requestNoficationById(@RequestParam("notificationId") int notificationId, Model model) {
			Notification notificationById = notificationSerivce.readOneNotificationById(notificationId);
			model.addAttribute("notificationById", notificationById);
			
			return "notification";
		}
		
	// Update
	
	// Delete
		@GetMapping("/deleteOneNotification")
		public String requestDeleteNotification(@RequestParam("notificationId") int notificationId) {
			notificationSerivce.deleteOneNotification(notificationId);
			return "redirect:/notificationList";
		}
}
