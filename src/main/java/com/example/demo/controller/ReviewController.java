package com.example.demo.controller;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.mapper.ReviewDtoMapper;
import com.example.demo.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
