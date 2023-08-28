package com.resort.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.resort.domain.Review;

@Mapper
public interface ReviewMapper {
	// Create
		void createOneReview(@Param("Review") Review review);
	
	// Read
		List<Review>readAllReview();
	
	// Update
		void updateOneReview(@Param("Review") Review review);
		
	// Delete
		void deleteOneReview(@Param("reviewId") int reviewId);
}
