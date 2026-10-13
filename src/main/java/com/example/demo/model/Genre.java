package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Genre")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GenreID", nullable = false)
  private Short genreId;

  @Column(name = "GenreName", length = 50, nullable = false, unique = true)
  private String genreName;
}
