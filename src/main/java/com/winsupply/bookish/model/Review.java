package com.winsupply.bookish.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Review")
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ReviewID", nullable = false)
  private Integer reviewId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "BookId", nullable = false)
  private Book book;

  @Column(name = "ReviewText", nullable = false, length = 3500)
  private String reviewText;

  @Column(name = "Rating", nullable = false)
  private Byte rating;

  @Column(name = "Isrecommended", nullable = false)
  private Boolean isRecommended;

  @Column(name = "DatePosted", nullable = false)
  private LocalDateTime datePosted;

  @OneToMany(mappedBy = "review")
  private List<Comment> comments = new ArrayList<>();

  public Review() {}

  public Integer getReviewId() {
    return reviewId;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public Byte getRating() {
    return rating;
  }

  public void setRating(Byte rating) {
    this.rating = rating;
  }

  public Boolean getIsRecommended() {
    return isRecommended;
  }

  public void setIsRecommended(Boolean isRecommended) {
    this.isRecommended = isRecommended;
  }

  public LocalDateTime getDatePosted() {
    return datePosted;
  }

  public void setDatePosted(LocalDateTime datePosted) {
    this.datePosted = datePosted;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}
