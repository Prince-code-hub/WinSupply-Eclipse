package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.ReviewDto;
import com.winsupply.bookish.mapper.ReviewDtoMapper;
import com.winsupply.bookish.model.Review;
import com.winsupply.bookish.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "review", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

  private final ReviewDtoMapper reviewDtoMapper;

  private final ReviewService reviewService;

  @GetMapping
  ResponseEntity<List<ReviewDto>> getAllReviews() {
    return new ResponseEntity<>(
        reviewDtoMapper.toDtoList(reviewService.getAllReviews()), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> submitReview(@RequestBody ReviewDto reviewDto) {
    Review review;
    try {
      review = reviewService.createReviewRequest(reviewDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(review, HttpStatus.OK);
  }

  @PutMapping(path = "{id}")
  ResponseEntity<Object> updateReview(
      @PathVariable("id") Integer id, @RequestBody ReviewDto reviewDto) {
    Review review;
    try {
      review = reviewService.putReview(id, reviewDto);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(review, HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<ReviewDto> getReviewById(@PathVariable("id") Integer id) {
    return new ResponseEntity<>(
        reviewDtoMapper.toDto(reviewService.getReviewById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "search")
  ResponseEntity<List<ReviewDto>> searchReviews(@RequestParam("text") String text) {
    return new ResponseEntity<>(
        reviewDtoMapper.toDtoList(reviewService.searchReviews(text)), HttpStatus.OK);
  }

  // delete review by ID
  @DeleteMapping(path = "{id}")
  ResponseEntity<Void> deleteReview(@PathVariable Integer id) {
    reviewService.deleteReview(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
