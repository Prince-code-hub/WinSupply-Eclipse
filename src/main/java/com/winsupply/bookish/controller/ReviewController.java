package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.ReviewDTO;
import com.winsupply.bookish.mapper.ReviewDtoMapper;
import com.winsupply.bookish.model.Review;
import com.winsupply.bookish.service.ReviewService;
import com.winsupply.bookish.dto.CreateBookReviewDTO;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  ResponseEntity<List<ReviewDTO>> getAllReviews() {
    return new ResponseEntity<>(
        reviewDtoMapper.toDtoList(reviewService.getAllReviews()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<ReviewDTO> getReviewById(@PathVariable("id") Integer id) {
    return new ResponseEntity<>(
        reviewDtoMapper.toDto(reviewService.getReviewById(id)), HttpStatus.OK);
  }

  @GetMapping(path = "search")
  ResponseEntity<List<ReviewDTO>> searchReviews(@RequestParam("text") String text) {
    return new ResponseEntity<>(
        reviewDtoMapper.toDtoList(reviewService.searchReviews(text)), HttpStatus.OK);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> createReview(@RequestBody ReviewDTO reviewDTO) {
    try {
      Review review = reviewService.createReview(reviewDTO);
      return new ResponseEntity<>(reviewDtoMapper.toDto(review), HttpStatus.CREATED);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "/with-book",consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> createBookReview(@RequestBody CreateBookReviewDTO dto) {
    try {
      Review review = reviewService.createBookReview(dto);
      return new ResponseEntity<>(reviewDtoMapper.toDto(review), HttpStatus.CREATED);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping(path = "{id}")
  ResponseEntity<Object> updateReview(
      @PathVariable("id") Integer id, @RequestBody ReviewDTO reviewDTO) {
    Review review;
    try {
      review = reviewService.updateReview(id, reviewDTO);
    } catch (EntityNotFoundException e) {
      return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(reviewDtoMapper.toDto(review), HttpStatus.OK);
  }
}
