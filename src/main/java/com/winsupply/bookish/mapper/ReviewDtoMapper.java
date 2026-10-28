package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.ReviewDTO;
import com.winsupply.bookish.model.Review;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewDtoMapper {

  @Mapping(target = "book.bookId", source = "bookId")
  Review toEntity(ReviewDTO reviewDto);

  @Mapping(target = "bookId", source = "book.bookId")
  ReviewDTO toDto(Review review) throws EntityNotFoundException;

  @InheritConfiguration
  @Mapping(target = "reviewId", ignore = true)
  Review updateEntity(ReviewDTO reviewDTO, @MappingTarget Review review);

  List<ReviewDTO> toDtoList(List<Review> reviewList);
}
