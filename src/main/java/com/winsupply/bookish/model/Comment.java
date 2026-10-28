package com.winsupply.bookish.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

@Data
@Entity
@Table(name = "Comment")
public class Comment {

  @Id
  @Column(name = "CommentID", nullable = false, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer commentId;

  @JoinColumn(name = "ReviewID", nullable = false)
  @ManyToOne
  Review review;

  @Column(name = "CommentText", length = 2500, nullable = false)
  String commentText;

  @Column(name = "DatePosted", nullable = false)
  @CreationTimestamp(source = SourceType.DB)
  LocalDateTime datePosted;
}
