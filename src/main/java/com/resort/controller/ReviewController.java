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
		public String submitNewReview(@ModelAttribute("newReview") Review review, Model model) {
			if (review.getReviewImageFile().getContentType().contains("image/")) {
				String uuid = UUID.randomUUID().toString().replaceAll(" ", "");
				String reviewTitle = review.getReviewTitle().replaceAll(" ", "");
				String originalFileName = review.getReviewImageFile().getOriginalFilename().replaceAll(" ", "");
				String imageFileName = uuid + "_" + reviewTitle + "_" + originalFileName;
				
				review.setReviewImagePath(imageFileName);
				try {
					review.getReviewImageFile().transferTo(new File("C:\\03StringWorkspace\\ResortReservation\\src\\main\\webapp\\resources\\imageFiles\\" + imageFileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				model.addAttribute("fileTypeAlert", "true");
				return "newReview";
			}
			reviewService.createOneReview(review);
			System.out.println("리뷰 아이디 : " + review.getReviewId());
			return "redirect:/review?reviewId=" + review.getReviewId();
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
		@GetMapping("/updateOneReview")
		public String requestUpdateOneReview(@RequestParam("reviewId") int reviewId, Model model) {
			Review reviewById = reviewService.readOneReviewById(reviewId);
			model.addAttribute("updateReview", reviewById);
			return "updateReview";
		}
		
		@PostMapping("/updateOneReview")
		public String submitUpdateOneReview(@ModelAttribute("updateReview") Review review) {
			reviewService.updateOneReview(review);
			int reviewId = review.getReviewId();
			return "redirect:/review?reviewId=" + reviewId;
		}
		
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
