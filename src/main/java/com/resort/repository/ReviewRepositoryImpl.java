package com.resort.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.resort.domain.Review;
import com.resort.mapper.ReviewMapper;
import com.resort.repository.Repository.ReviewRepository;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

	@Autowired
	private ReviewMapper reviewMapper;
	
	private List<Review> listofReivew;
	
	// Create
		@Override
		public void createOneReview(Review review) {
			reviewMapper.createOneReview(review);
		}
	
	// Read
		@Override
		public List<Review> readAllReview() {
			listofReivew = reviewMapper.readAllReview();
			return listofReivew;
		}
		
		@Override
		public Review readOneReviewById(int reviewId) {
			Review reviewById = null;
			listofReivew = reviewMapper.readAllReview();
			if (listofReivew != null) {
				for (Review review : listofReivew) {
					if (review.getReviewId() == reviewId) {
						reviewById = review;
					}
				}
			}
			return reviewById;
		}

	// Update
		@Override
		public void updateOneReview(Review review) {
			reviewMapper.updateOneReview(review);
		}
		
	// Delete
		@Override
		public void deleteOneReview(int reviewId) {
			reviewMapper.deleteOneReview(reviewId);
		}

}
