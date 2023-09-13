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
	private String imageDirectory = "/home/kopo17/upload/";

	// Create
	@GetMapping("/newReview")
	public String requestNewReivew(@ModelAttribute("newReview") Review review, Model model) {
		model.addAttribute("fileTypeAlert", "");
		return "review/newReview";
	}

	@PostMapping("/newReview")
	public String submitNewReview(@ModelAttribute("newReview") Review review, Model model) {
		if (!review.getReviewImageFile().getOriginalFilename().equals("")) {
			if (review.getReviewImageFile().getContentType().contains("image/")) {
				String uuid = UUID.randomUUID().toString().replaceAll(" ", "");
				String reviewTitle = review.getReviewTitle().replaceAll(" ", "");
				String originalFileName = review.getReviewImageFile().getOriginalFilename().replaceAll(" ", "");
				String imageFileName = uuid + "_" + reviewTitle + "_" + originalFileName;
				model.addAttribute("fileTypeAlert", "");

				review.setReviewImagePath(imageFileName);
				try {
					review.getReviewImageFile().transferTo(new File(imageDirectory + imageFileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				model.addAttribute("fileTypeAlert", "alert");
				return "review/newReview";
			}
		}
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
	public String requestReviewList(@RequestParam("currentPage") int currentPage, Model model) {
		int pageCnt = 10;
		listOfReview = reviewService.readAllReview();
		List<List<Review>> pagesOfReview = new ArrayList<List<Review>>();
		
		for (int i = 0; i < listOfReview.size(); i = i + pageCnt) {
			List<Review> reviewPerPage = new ArrayList<Review>();
			for (int j = i; j < i + pageCnt; j++) {
				try {
					reviewPerPage.add(listOfReview.get(j));
				} catch (IndexOutOfBoundsException ie) {
					break;
				}
			}
			pagesOfReview.add(reviewPerPage);
		}
		if (currentPage < 1) {
			currentPage = 1;
		}
		if (currentPage > pagesOfReview.size()) {
			currentPage = pagesOfReview.size();
		}
		
		int currentTabStart = (currentPage / 10)*10 + 1;
		int currentTabEnd = currentTabStart + 9;
		
		if (currentTabEnd > pagesOfReview.size()) {
			currentTabEnd = pagesOfReview.size(); 
		}
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("currentTabStart", currentTabStart);
		model.addAttribute("currentTabEnd", currentTabEnd);
		model.addAttribute("totalPage", pagesOfReview.size());
		model.addAttribute("notificationList", pagesOfReview.get(currentPage -1));
		
		model.addAttribute("reviewList", listOfReview);

		return "review/reviewList";
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
		return "review/review";
	}

	// Update
	@GetMapping("/updateOneReview")
	public String requestUpdateOneReview(@RequestParam("reviewId") int reviewId, Model model) {
		Review reviewById = reviewService.readOneReviewById(reviewId);
		model.addAttribute("updateReview", reviewById);
		return "review/updateReview";
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
		String imagePath = reviewService.readOneReviewById(reviewId).getReviewImagePath();
		File file = new File(imageDirectory + imagePath);
		file.delete();
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
