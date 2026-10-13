package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BookID", nullable = false)
  private Integer bookId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "GenreID", nullable = false)
  private Genre genre;
}
