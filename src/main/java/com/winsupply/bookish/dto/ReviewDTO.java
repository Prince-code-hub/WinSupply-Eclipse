package com.winsupply.bookish.dto;

// import com.winsupply.bookish.model.Book;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class ReviewDTO {
  Integer reviewId;
  // Book book;
  Integer bookId;
  String reviewText;
  Byte rating;
  Boolean isRecommended;
  LocalDateTime datePosted;
}
