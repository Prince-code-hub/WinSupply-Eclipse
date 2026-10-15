package com.example.demo.service;

import com.example.demo.dto.GenreDto;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.model.Genre;
import com.example.demo.repository.GenreRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

  private final GenreRepo genreRepo;
  private final GenreMapper genreMapper;

  public GenreService(GenreRepo genreRepo, GenreMapper genreMapper) {
    this.genreRepo = genreRepo;
    this.genreMapper = genreMapper;
  }

  public List<GenreDto> getAllGenres() {
    return genreMapper.toDtoList(genreRepo.findAll());
  }

  public GenreDto getGenreById(Short id) throws EntityNotFoundException {
    Optional<Genre> result = genreRepo.findById(id);

    if (result.isEmpty()) {
      throw new EntityNotFoundException("Genre (" + id + ") not found");
    }

    return genreMapper.toDto(result.get());
  }

  public List<GenreDto> getGenresByName(String name) {
    Optional<List<Genre>> result = genreRepo.findByGenreNameContainingIgnoreCase(name);

    if (result.isEmpty() || result.get().isEmpty()) {
      throw new EntityNotFoundException("Genre(s) with name (" + name + ") not found");
    }

    return genreMapper.toDtoList(result.get());
  }
}
