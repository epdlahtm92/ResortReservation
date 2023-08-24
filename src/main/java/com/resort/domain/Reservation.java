package com.resort.domain;

public class Reservation {
	
	private int userId;
	private String name;
	private int reservationRoom;
	private String reservationDate;
	private String address;
	private String phoneNumber;
	private String payer;
	private String userComment;
	private String requestDate;
	private int reservationStatus;
	
	public Reservation() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getReservationRoom() {
		return reservationRoom;
	}
	public void setReservationRoom(int reservationRoom) {
		this.reservationRoom = reservationRoom;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPayer() {
		return payer;
	}
	public void setPayer(String payer) {
		this.payer = payer;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public int getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
	
	
}
