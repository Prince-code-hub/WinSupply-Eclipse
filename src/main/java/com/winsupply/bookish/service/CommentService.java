package com.winsupply.bookish.service;

import com.winsupply.bookish.dto.CommentDto;
import com.winsupply.bookish.mapper.CommentMapper;
import com.winsupply.bookish.model.Comment;
import com.winsupply.bookish.model.Review;
import com.winsupply.bookish.repository.CommentRepo;
import com.winsupply.bookish.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

  private final CommentRepo commentRepo;
  private final ReviewRepository reviewRepo;
  private final CommentMapper commentMapper;

  // create comment on an existing review
  public Comment createCommentRequest(CommentDto commentDto) {

    Review review = reviewRepo
        .findById(commentDto.getReviewId())
        .orElseThrow(() ->
            new EntityNotFoundException("Review (" + commentDto.getReviewId() + ") not found"));

    Comment comment = commentMapper.toEntity(commentDto);
    comment.setReview(review);

    return commentRepo.saveAndFlush(comment);
  }

  // get all comments
  public List<Comment> getAllComments() {
    return commentRepo.findAll();
  }

  // get comment by ID
  public Comment getCommentById(Integer id) {
    return commentRepo
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Comment (" + id + ") not found"));
  }

  // get all comments on a specific review
  public List<Comment> getCommentsByReviewId(Integer reviewId) {

    if (!reviewRepo.existsById(reviewId)) {
      throw new EntityNotFoundException("Review (" + reviewId + ") not found");
    }

    return commentRepo.findByReview_ReviewId(reviewId);
  }

  // search comments by text
  public List<Comment> searchComments(String text) {

    List<Comment> result = commentRepo.findByCommentTextContainingIgnoreCase(text);

    if (result.isEmpty()) {
      throw new EntityNotFoundException("Comment(s) with text (" + text + ") not found");
    }

    return result;
  }

  // update existing comment
  public Comment putComment(Integer id, CommentDto commentDto) {

    Comment comment = commentRepo
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Comment (" + id + ") not found"));

    return commentRepo.saveAndFlush(commentMapper.updateEntity(commentDto, comment));
  }

  // delete comment by ID
  public void deleteComment(Integer id) {
    Comment comment = commentRepo
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Comment (" + id + ") not found"));

    commentRepo.delete(comment);
  }
}
