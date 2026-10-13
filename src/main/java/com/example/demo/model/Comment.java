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
}
