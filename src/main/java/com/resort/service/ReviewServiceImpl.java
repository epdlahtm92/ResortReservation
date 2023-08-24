package com.resort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resort.domain.Review;
import com.resort.repository.Repository;
import com.resort.service.Service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private Repository.ReviewRepository reviewRepository;
	
	// Create
		@Override
		public void createOneReview(Review review) {
			reviewRepository.createOneReview(review);
			
		}
	
	// Read
		@Override
		public List<Review> readAllReview() {
			return reviewRepository.readAllReview();
		}

		

}
