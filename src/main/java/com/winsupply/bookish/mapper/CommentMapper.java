package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.CommentDto;
import com.winsupply.bookish.model.Comment;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CommentMapper {

  @Mapping(target = "review.reviewId", source = "reviewId")
  @Mapping(target = "commentId", ignore = true)
  @Mapping(target = "datePosted", ignore = true)
  Comment toEntity(CommentDto commentDto) throws EntityNotFoundException;

  @Mapping(target = "reviewId", source = "review.reviewId")
  CommentDto toDto(Comment comment) throws EntityNotFoundException;

  List<CommentDto> toDtoList(List<Comment> commentList) throws EntityNotFoundException;

  @Mapping(target = "commentId", ignore = true)
  @Mapping(target = "review", ignore = true)
  @Mapping(target = "datePosted", ignore = true)
  Comment updateEntity(CommentDto commentDto, @MappingTarget Comment comment);
}
