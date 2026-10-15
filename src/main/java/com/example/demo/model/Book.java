package com.example.demo.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

  @Column(name = "Title", nullable = false)
  private String title;

  @Column(name = "PageCount")
  private Short pageCount;

  @OneToMany(mappedBy = "book")
  private List<Review> reviews = new ArrayList<>();

  public Book() {}

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public Genre getGenre() {
    return genre;
  }

  public void setGenre(Genre genre) {
    this.genre = genre;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Short getPageCount() {
    return pageCount;
  }

  public void setPageCount(Short pageCount) {
    this.pageCount = pageCount;
  }

  public List<Review> getReviews() {
    return reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }
}
