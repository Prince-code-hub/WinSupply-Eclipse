package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.ReviewDto;
import com.winsupply.bookish.model.Review;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewDtoMapper {

  @Mapping(target = "book.bookId", source = "bookId")
  Review toEntity(ReviewDto reviewDto) throws EntityNotFoundException;

  @Mapping(target = "bookId", source = "book.bookId")
  ReviewDto toDto(Review review) throws EntityNotFoundException;

  List<ReviewDto> toDtoList(List<Review> reviewList) throws EntityNotFoundException;

  @Mapping(target = "reviewId", ignore = true)
  @Mapping(target = "book", ignore = true)
  Review updateEntity(ReviewDto reviewDto, @MappingTarget Review review);
}
