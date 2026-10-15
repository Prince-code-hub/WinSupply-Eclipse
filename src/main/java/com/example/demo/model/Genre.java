package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Genre")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GenreID", nullable = false)
  Short genreId;

  @Column(name = "GenreName", length = 50, nullable = false, unique = true)
  String genreName;
}
