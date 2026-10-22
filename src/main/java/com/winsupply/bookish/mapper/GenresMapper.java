package com.winsupply.bookish.mapper;

import com.winsupply.bookish.dto.GenresDto;
import com.winsupply.bookish.model.Genre;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GenresMapper {
  public GenresDto toDto(Genre genre) {
    if (genre == null) {
      return null;
    }
    return new GenresDto(genre.getGenreId(), genre.getGenreName());
  }

  public List<GenresDto> toDtoList(List<Genre> genres) {
    return genres.stream().map(this::toDto).toList();
  }
}
