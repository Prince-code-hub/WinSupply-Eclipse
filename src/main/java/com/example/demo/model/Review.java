package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "Review")
public class Review {

  @Id
  @Column(name = "ReviewID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @JoinColumn(name = "BookID", nullable = false)
  @ManyToOne
  Book book;

  @Column(name = "ReviewText", length = 3500, nullable = false)
  String reviewText;

  @Column(name = "Rating", nullable = false)
  Integer rating;

  @Column(name = "IsRecommended", nullable = false)
  Boolean isRecommended;

  @Column(name = "DatePosted", nullable = false)
  @CreationTimestamp(source = SourceType.DB)
  Instant datePosted;
}
