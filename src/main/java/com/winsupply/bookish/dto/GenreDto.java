package com.winsupply.bookish.dto;

public class GenreDto {

  private Short genreId;
  private String genreName;

  public GenreDto() {}

  public GenreDto(Short genreId, String genreName) {
    this.genreId = genreId;
    this.genreName = genreName;
  }

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
}
