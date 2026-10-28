package com.winsupply.bookish.service;

import com.winsupply.bookish.dto.ReviewDto;
import com.winsupply.bookish.mapper.ReviewDtoMapper;
import com.winsupply.bookish.model.Review;
import com.winsupply.bookish.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final ReviewDtoMapper reviewDtoMapper;

  public Review createReviewRequest(ReviewDto reviewDto) throws EntityNotFoundException {
    return reviewRepository.saveAndFlush(reviewDtoMapper.toEntity(reviewDto));
  }

  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

  public Review getReviewById(Integer id) throws EntityNotFoundException {
    return reviewRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Review (" + id + ") not found"));
  }

  public List<Review> searchReviews(String text) {
    Optional<List<Review>> result = reviewRepository.findByReviewTextContainingIgnoreCase(text);
    if (result.isPresent() && result.get().isEmpty()) {
      throw new EntityNotFoundException("Review(s) with text (" + text + ") not found");
    }
    return result.get();
  }

  public Review putReview(Integer id, ReviewDto reviewDto) throws EntityNotFoundException {
    Review review = reviewRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Review (" + id + ") not found"));
    return reviewRepository.saveAndFlush(reviewDtoMapper.updateEntity(reviewDto, review));
  }
}
