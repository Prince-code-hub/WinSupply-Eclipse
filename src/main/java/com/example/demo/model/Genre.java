package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Genre")
public class Genre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "GenreID", nullable = false)
  private Short genreId;

  @OneToMany(mappedBy = "genre")
  private List<Book> books = new ArrayList<>();

  @Column(name = "GenreName", nullable = false, unique = true, length = 50)
  private String genreName;

  public Genre() {}

  public Short getGenreId() {
    return genreId;
  }

  public void setGenreId(Short genreId) {
    this.genreId = genreId;
  }

  public String getGenreName() {
    return genreName;
  }

  public void setGenreName(String genreName) {
    this.genreName = genreName;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }
}
