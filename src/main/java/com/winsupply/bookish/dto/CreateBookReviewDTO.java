package com.winsupply.bookish.dto;

import com.winsupply.bookish.model.Book;
import lombok.Data;

@Data
public class CreateBookReviewDTO {

  Book book;
  String reviewText;
  Byte rating;
  Boolean isRecommended;
}
