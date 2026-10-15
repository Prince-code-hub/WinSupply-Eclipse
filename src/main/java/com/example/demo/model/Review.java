package com.example.demo.model;

import jakarta.persistence.*;

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
}
