package com.winsupply.bookish.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class ReviewDto {
  Integer reviewId;
  Integer bookId;
  String reviewText;
  Byte rating;
  Boolean isRecommended;
  LocalDateTime datePosted;
}
