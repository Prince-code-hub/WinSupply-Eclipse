package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.CommentDto;
import com.winsupply.bookish.mapper.CommentMapper;
import com.winsupply.bookish.service.CommentService;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comment", produces = MediaType.APPLICATION_JSON_VALUE)
public class CommentController {

  private final CommentService commentService;
  private final CommentMapper commentMapper;

  public CommentController(CommentService commentService, CommentMapper commentMapper) {
    this.commentService = commentService;
    this.commentMapper = commentMapper;
  }

  // post comment on an existing review
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
    return new ResponseEntity<>(
        commentMapper.toDto(commentService.createCommentRequest(commentDto)), HttpStatus.CREATED);
  }

  // put update comment by ID
  @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<CommentDto> putComment(
      @PathVariable Integer id, @RequestBody CommentDto commentDto) {
    return new ResponseEntity<>(
        commentMapper.toDto(commentService.putComment(id, commentDto)), HttpStatus.OK);
  }

  // get comment by ID
  @GetMapping(path = "{id}")
  ResponseEntity<CommentDto> getCommentById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        commentMapper.toDto(commentService.getCommentById(id)), HttpStatus.OK);
  }

  // get all comments on a review ID
  @GetMapping(path = "review/{reviewId}")
  ResponseEntity<List<CommentDto>> getCommentsByReviewId(@PathVariable Integer reviewId) {
    return new ResponseEntity<>(
        commentMapper.toDtoList(commentService.getCommentsByReviewId(reviewId)), HttpStatus.OK);
  }

  // delete comment by ID
  @DeleteMapping(path = "{id}")
  ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
    commentService.deleteComment(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
