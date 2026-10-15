package com.example.demo.service;

import com.example.demo.model.Review;
import com.example.demo.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;

  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  public Review getReviewById(Integer id) throws EntityNotFoundException {
    return reviewRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Review (" + id + ") not found"));
  }

  public List<Review> searchReviews(String text) {
    return reviewRepository.findByReviewTextContainingIgnoreCase(text);
  }
}
