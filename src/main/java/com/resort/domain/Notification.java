package com.resort.domain;

import org.springframework.web.multipart.MultipartFile;

public class Notification {
	
	private int notificationId;
	private String notificationTitle;
	private String notificationContent;
	private String notificationDate;
	private MultipartFile notificationImageFile;
	private String notificationImagePath;
	private int notification_seq;
	
	public Notification() {
		super();
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public String getNotificationTitle() {
		return notificationTitle;
	}
	public void setNotificationTitle(String notificationTitle) {
		this.notificationTitle = notificationTitle;
	}
	public String getNotificationContent() {
		return notificationContent;
	}
	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}
	public String getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(String notificationDate) {
		this.notificationDate = notificationDate;
	}
	public MultipartFile getNotificationImageFile() {
		return notificationImageFile;
	}
	public void setNotificationImageFile(MultipartFile notificationImageFile) {
		this.notificationImageFile = notificationImageFile;
	}
	public String getNotificationImagePath() {
		return notificationImagePath;
	}
	public void setNotificationImagePath(String notificationImagePath) {
		this.notificationImagePath = notificationImagePath;
	}
	public int getNotification_seq() {
		return notification_seq;
	}
	public void setNotification_seq(int notification_seq) {
		this.notification_seq = notification_seq;
	}
	
	
}
