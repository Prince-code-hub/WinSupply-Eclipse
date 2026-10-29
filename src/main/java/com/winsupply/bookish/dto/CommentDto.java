package com.winsupply.bookish.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class CommentDto {
  Integer commentId;
  Integer reviewId;
  String commentText;
  LocalDateTime datePosted;
}
