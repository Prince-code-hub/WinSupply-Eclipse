package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.GenreDto;
import com.winsupply.bookish.model.Genre;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

  public GenreDto toDto(Genre genre) {
    if (genre == null) {
      return null;
    }
    return new GenreDto(genre.getGenreId(), genre.getGenreName());
  }

  public List<GenreDto> toDtoList(List<Genre> genres) {
    return genres.stream().map(this::toDto).toList();
  }
}
