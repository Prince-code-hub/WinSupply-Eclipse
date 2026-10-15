package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.model.Book;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

  @Mapping(source = "genre.genreId", target = "genreId")
  BookDto toDto(Book book) throws EntityNotFoundException;

  List<BookDto> toDtoList(List<Book> bookList) throws EntityNotFoundException;
}
