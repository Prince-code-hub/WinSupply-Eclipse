package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.ReviewDTO;
import com.winsupply.bookish.model.Review;
import com.winsupply.bookish.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {ReviewService.class})
public interface ReviewDtoMapper {

  @Mapping(target = "book", ignore = true)
  Review toEntity(ReviewDTO reviewDto) throws EntityNotFoundException;

  @Mapping(target = "bookId", source = "book.bookId")
  ReviewDTO toDto(Review review) throws EntityNotFoundException;

  List<ReviewDTO> toDtoList(List<Review> reviewList) throws EntityNotFoundException;
}
