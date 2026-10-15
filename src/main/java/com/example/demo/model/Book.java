package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BookID", nullable = false)
  Integer bookId;

  @Column(name = "Title", length = 50, nullable = false)
  String title;

  @Column(name = "Author", length = 50, nullable = false)
  String author;

  @JoinColumn(name = "GenreID", nullable = false)
  @ManyToOne
  Genre genre;

  @Column(name = "PageCount", nullable = false)
  Short pageCount;

  @Column(name = "DatePosted", nullable = false)
  LocalDate datePosted;
}
