package com.example.demo.mapper;

import com.example.demo.dto.GenreDto;
import com.example.demo.model.Genre;
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
