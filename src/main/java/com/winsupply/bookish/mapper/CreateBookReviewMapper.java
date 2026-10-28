package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.CreateBookReviewDTO;
import com.winsupply.bookish.model.Book;
import com.winsupply.bookish.model.Genre;
import com.winsupply.bookish.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateBookReviewMapper {

    @Mapping(target = "reviewId", ignore = true)
    @Mapping(target = "book.bookId", ignore = true)
    @Mapping(target = "book.genre", source = "genre")
    @Mapping(target = "book.title", source = "dto.book.title")
    @Mapping(target = "book.pageCount", source = "dto.book.pageCount")
    @Mapping(target = "datePosted", ignore = true)
    Review toEntity(CreateBookReviewDTO dto, Genre genre);
}