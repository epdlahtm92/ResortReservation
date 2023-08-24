package com.resort.domain;

public class RoomStatus {

	private String reservationDate;
	private String room0Status;
	private String room1Status;
	private String room2Status;
	
	public RoomStatus() {
		super();
	}
	
	public RoomStatus(String room0Status, String room1Status, String room2Status) {
		super();
		this.room0Status = room0Status;
		this.room1Status = room1Status;
		this.room2Status = room2Status;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getRoom0Status() {
		return room0Status;
	}

	public void setRoom0Status(String room0Status) {
		this.room0Status = room0Status;
	}

	public String getRoom1Status() {
		return room1Status;
	}

	public void setRoom1Status(String room1Status) {
		this.room1Status = room1Status;
	}

	public String getRoom2Status() {
		return room2Status;
	}

	public void setRoom2Status(String room2Status) {
		this.room2Status = room2Status;
	}

	
	
	

}
