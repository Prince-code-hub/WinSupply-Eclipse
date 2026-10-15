package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Comment")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CommentID", nullable = false)
  private Integer commentId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ReviewID", nullable = false)
  private Review review;

  @Column(name = "CommentText", nullable = false, length = 2500)
  private String commentText;

  @Column(name = "DatePosted", nullable = false)
  private LocalDateTime datePosted;

  public Comment() {}

  public Integer getCommentId() {
    return commentId;
  }

  public void setCommentId(Integer commentId) {
    this.commentId = commentId;
  }

  public Review getReview() {
    return review;
  }

  public void setReview(Review review) {
    this.review = review;
  }

  public String getCommentText() {
    return commentText;
  }

  public void setCommentText(String commentText) {
    this.commentText = commentText;
  }

  public LocalDateTime getDatePosted() {
    return datePosted;
  }

  public void setDatePosted(LocalDateTime datePosted) {
    this.datePosted = datePosted;
  }
}
