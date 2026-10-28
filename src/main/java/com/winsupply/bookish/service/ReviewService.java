package com.winsupply.bookish.service;

import com.winsupply.bookish.dto.CreateBookReviewDTO;
import com.winsupply.bookish.dto.ReviewDTO;
import com.winsupply.bookish.mapper.*;
import com.winsupply.bookish.model.*;
import com.winsupply.bookish.repository.*;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final BookService bookService;
  private final CreateBookReviewMapper createBookReviewMapper;
  private final BookRepo bookRepo;
  private final ReviewDtoMapper reviewDtoMapper;

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

  public Review createReview(ReviewDTO reviewDTO) throws EntityNotFoundException {
    return reviewRepository.saveAndFlush(reviewDtoMapper.toEntity(reviewDTO));
  }

  public Review createBookReview(CreateBookReviewDTO dto) throws EntityNotFoundException {
    Review review = createBookReviewMapper.toEntity(dto, dto.getBook().getGenre());

    review.setDatePosted(LocalDateTime.now());

    bookRepo.saveAndFlush(review.getBook());
    return reviewRepository.saveAndFlush(review);
  }

  public Review updateReview(Integer id, ReviewDTO reviewDTO) throws EntityNotFoundException {
    Review review = reviewRepository
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Review (" + id + ") not found"));
    return reviewRepository.saveAndFlush(reviewDtoMapper.updateEntity(reviewDTO, review));
  }
}
