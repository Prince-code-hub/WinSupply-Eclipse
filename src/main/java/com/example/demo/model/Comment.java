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
  private Integer commentId;

  @JoinColumn(name = "ReviewID", nullable = false)
  @ManyToOne
  private Review review;

  @Column(name = "CommentText", length = 2500, nullable = false)
  private String commentText;

  @Column(name = "DatePosted", nullable = false)
  private LocalDateTime datePosted;
}
