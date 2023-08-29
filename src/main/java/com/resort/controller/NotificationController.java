package com.resort.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

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
	private String imageDirectory = "C:\\03StringWorkspace\\ResortReservation\\src\\main\\webapp\\resources\\imageFiles\\";
	
	// Create
		@GetMapping("/newNotification")
		public String requestNewNotification(@ModelAttribute("newNotification") Notification notification, Model model) {
			model.addAttribute("fileTypeAlert", "");
			return "notification/newNotification";
		}
		
		@PostMapping("/newNotification") 
		public String submitNewNotification(@ModelAttribute("newNotification") Notification notification, Model model) {
			if (!notification.getNotificationImageFile().getOriginalFilename().equals("")) {
				if (notification.getNotificationImageFile().getContentType().contains("image/")) {
					String uuid = UUID.randomUUID().toString().replaceAll(" ", "");
					String notificationTitle = notification.getNotificationTitle().replaceAll(" ", "");
					String originalFileName = notification.getNotificationImageFile().getOriginalFilename().replaceAll(" ", "");
					String imageFileName = uuid + "_" + notificationTitle + "_" + originalFileName;
					model.addAttribute("fileTypeAlert", "");
					
					notification.setNotificationImagePath(imageFileName);
					try {
						notification.getNotificationImageFile().transferTo(new File(imageDirectory + imageFileName));
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					model.addAttribute("fileTypeAlert", "alert");
					return "notification/newNotification";
				}
			}
			
			notificationSerivce.createNewNotification(notification);
			return "redirect:/notificationList";
		}
	
	// Read
		@GetMapping("/notificationList")
		public String requestNotificationList(Model model) {
			
			listofNotification = notificationSerivce.readAllNotification();
			
			model.addAttribute("notificationList", listofNotification);
			
			return "notification/notificationList";
		}
		
		@GetMapping("/notification")
		public String requestNoficationById(@RequestParam("notificationId") int notificationId, Model model) {
			Notification notificationById = notificationSerivce.readOneNotificationById(notificationId);
			model.addAttribute("notificationById", notificationById);
			
			return "notification/notification";
		}
		
	// Update
		@GetMapping("/updateOneNotification")
		public String requestUpdateNotification(@RequestParam("notificationId") int notificationId, Model model) {
			Notification updateNotification = notificationSerivce.readOneNotificationById(notificationId);
			model.addAttribute("updateNotification", updateNotification);
			return "notification/updateNotification";
		}
		
		@PostMapping("/updateOneNotification")
		public String submitUpdateNotification(@ModelAttribute("updateNotification") Notification notification, Model model) {
			notificationSerivce.updateOneNotification(notification);
			int notificationId = notification.getNotificationId();
			return "redirect:/notification?notificationId=" + notificationId;
		}
	
	// Delete
		@GetMapping("/deleteOneNotification")
		public String requestDeleteNotification(@RequestParam("notificationId") int notificationId) {
			String imagePath = notificationSerivce.readOneNotificationById(notificationId).getNotificationImagePath();
			File file = new File(imageDirectory + imagePath);
			file.delete();
			notificationSerivce.deleteOneNotification(notificationId);
			return "redirect:/notificationList";
		}
}
