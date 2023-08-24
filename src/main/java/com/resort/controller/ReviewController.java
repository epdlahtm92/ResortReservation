package com.resort.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.resort.domain.Review;
import com.resort.service.Service;

@Controller
public class ReviewController {
	
	@Autowired
	private Service.ReviewService reviewService;
	
	private List<Review> listOfReview;
	
	// Create
		@GetMapping("/newReview")
		public String requestNewReivew(@ModelAttribute("newReview") Review review) {
			return "newReview";
		}
	
		@PostMapping("/newReview")
		public String submitNewReview(@ModelAttribute("newReview") Review review) {
			reviewService.createOneReview(review);
			return "redirect:/reviewList";
		}
	
	// Read
		@GetMapping("/reviewList")
		public String requestReviewList(Model model) {
			listOfReview = reviewService.readAllReview();
			model.addAttribute("reviewList", listOfReview);
			
			return "reviewList";
		}
		
		@GetMapping("/review")
		public String requestReviewById(@Param("reviewId") int reviewId, Model model) {
			listOfReview = reviewService.readAllReview();
			Review reviewById = null;
			for (Review review : listOfReview) {
				if(reviewId == review.getReviewId()) {
					reviewById = review;
				}
			}
			
			model.addAttribute("reviewById", reviewById);
			return "review";
		}
	}
