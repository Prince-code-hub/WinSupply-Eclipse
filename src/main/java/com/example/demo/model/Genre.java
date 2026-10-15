package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Genre")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GenreID", nullable = false)
  private Short genreId;

  @Column(name = "GenreName", nullable = false, unique = true, length = 50)
  private String genreName;
}
