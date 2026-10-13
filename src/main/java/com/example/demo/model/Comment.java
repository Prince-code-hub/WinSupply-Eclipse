package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Comment")
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CommentID", nullable = false)
  Integer commentId;

  @JoinColumn(name = "ReviewID", nullable = false)
  @ManyToOne
  Review review;

  @Column(name = "CommentText", length = 2500, nullable = false)
  String commentText;

  @Column(name = "DatePosted", nullable = false)
  LocalDateTime datePosted;
}
