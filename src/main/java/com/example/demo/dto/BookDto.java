package com.example.demo.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class BookDto {

  Integer bookId;
  String title;
  Integer genreId;
  Short pageCount;
  LocalDate datePosted;
}
