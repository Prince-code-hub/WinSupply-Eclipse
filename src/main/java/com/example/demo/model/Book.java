package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Book")
public class Book {

  @Id
  @Column(name = "BookID", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @JoinColumn(name = "GenreID", nullable = false)
  @ManyToOne
  Genre genre;

  @Column(name = "Title", length = 50, nullable = false)
  String title;

  @Column(name = "PageCount")
  Integer pageCount;
}
