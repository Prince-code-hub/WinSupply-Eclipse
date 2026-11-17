package com.winsupply.bookish.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class BookDto {

  Integer bookId;
  String title;
  String author;
  Integer genreId;
  Short pageCount;
  LocalDateTime datePosted;
}
