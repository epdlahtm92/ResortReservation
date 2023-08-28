package com.resort.domain;

import org.springframework.web.multipart.MultipartFile;

public class Review {
	
	private int reviewId;
	private String reviewTitle;
	private String reviewContent;
	private String reviewUser;
	private String reviewDate;
	private MultipartFile reviewImageFile;
	private String reviewImagePath;
	
	public String getReviewImagePath() {
		return reviewImagePath;
	}
	public void setReviewImagePath(String reviewImagePath) {
		this.reviewImagePath = reviewImagePath;
	}
	public Review() {
		super();

	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewUser() {
		return reviewUser;
	}
	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}
	public MultipartFile getReviewImageFile() {
		return reviewImageFile;
	}
	public void setReviewImageFile(MultipartFile reviewImageFile) {
		this.reviewImageFile = reviewImageFile;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
}
