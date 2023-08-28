package com.resort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.resort.domain.Reply;
import com.resort.domain.Review;
import com.resort.service.Service;

@Controller
public class ReviewController {
	
	@Autowired
	private Service.ReviewService reviewService;
	
	@Autowired
	private Service.ReplyService replyService;
	
	
	private List<Review> listOfReview;
	private List<Reply> listOfReply;
	
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
		
		@PostMapping("/review")
		public String submitNewReply(@ModelAttribute("newReply") Reply reply) {
			replyService.createOneReply(reply);
			return "redirect:/review?reviewId=" + reply.getRootId();
		}
	
	// Read
		@GetMapping("/reviewList")
		public String requestReviewList(Model model) {
			listOfReview = reviewService.readAllReview();
			model.addAttribute("reviewList", listOfReview);
			
			return "reviewList";
		}
		
		@GetMapping("/review")
		public String requestReviewById(@RequestParam("reviewId") int reviewId, @ModelAttribute("newReply") Reply reply, Model model) {
			listOfReview = reviewService.readAllReview();
			listOfReply = replyService.readAllReply(reviewId);
			Review reviewById = null;
			for (Review review : listOfReview) {
				if(reviewId == review.getReviewId()) {
					reviewById = review;
					
				}
			}
			
			model.addAttribute("reviewById", reviewById);
			model.addAttribute("replyList", listOfReply);
			return "review";
		}
		
	// Update
		
	// Delete
		@GetMapping("/deleteOneReview")
		public String requestDeleteOneReview(@RequestParam("reviewId") int reviewId) {
			reviewService.deleteOneReview(reviewId);
			replyService.deleteAllReply(reviewId);
			return "redirect:/reviewList";
		}
		
		@GetMapping("/deleteOneReviewReply")
		public String requestDeleteOneReviewReply(@RequestParam("reviewId") int reviewId, @RequestParam("replyId") int replyId) {
			replyService.deleteOneReply(replyId);
			return "redirect:/review?reviewId=" + reviewId;
		}
	}
