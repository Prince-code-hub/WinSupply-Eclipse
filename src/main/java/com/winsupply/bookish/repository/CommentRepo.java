package com.winsupply.bookish.repository;

import com.winsupply.bookish.model.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
  List<Comment> findByReview_ReviewId(Integer reviewId);

  List<Comment> findByCommentTextContainingIgnoreCase(String text);
}
