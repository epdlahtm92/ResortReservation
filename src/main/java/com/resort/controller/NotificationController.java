package com.resort.controller;

import java.io.File;
import java.util.ArrayList;
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
	private String imageDirectory = "/home/kopo17/upload/";
	
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
		public String requestNotificationList(@RequestParam("currentPage") int currentPage, Model model) {
			int pageCnt = 10;
			listofNotification = notificationSerivce.readAllNotification();
			List<List<Notification>> pagesOfNotification = new ArrayList<List<Notification>>();
			
			for (int i = 0; i <listofNotification.size(); i = i+pageCnt) {
				List<Notification> notificationPerPage = new ArrayList<Notification>();
				for (int j = i; j < i + pageCnt; j++) {
					try {
						notificationPerPage.add(listofNotification.get(j));
					} catch (IndexOutOfBoundsException ie) {
						break;
					}
				}
				pagesOfNotification.add(notificationPerPage);
			}
			if (currentPage < 1) {
				currentPage = 1;
			}
			if (currentPage > pagesOfNotification.size()) {
				currentPage = pagesOfNotification.size();
			}
			
			int currentTabStart = (currentPage / 10)*10 + 1;
			int currentTabEnd = currentTabStart + 9;
			
			if (currentTabEnd > pagesOfNotification.size()) {
				currentTabEnd = pagesOfNotification.size(); 
			}
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("currentTabStart", currentTabStart);
			model.addAttribute("currentTabEnd", currentTabEnd);
			model.addAttribute("totalPage", pagesOfNotification.size());
			model.addAttribute("notificationList", pagesOfNotification.get(currentPage -1));
			
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
