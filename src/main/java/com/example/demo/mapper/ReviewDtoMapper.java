package com.example.demo.mapper;

import com.example.demo.dto.ReviewDTO;
import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {ReviewService.class})
public interface ReviewDtoMapper {

  Review toEntity(ReviewDTO reviewDto) throws EntityNotFoundException;

  @Mapping(target = "bookId", source = "book.bookId")
  ReviewDTO toDto(Review review) throws EntityNotFoundException;

  List<ReviewDTO> toDtoList(List<Review> reviewList) throws EntityNotFoundException;
}
