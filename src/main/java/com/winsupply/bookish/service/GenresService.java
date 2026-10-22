package com.winsupply.bookish.service;

import com.winsupply.bookish.dto.GenresDto;
import com.winsupply.bookish.mapper.GenresMapper;
import com.winsupply.bookish.model.Genre;
import com.winsupply.bookish.repository.GenresRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GenresService {

  private final GenresRepo genresRepo;
  private final GenresMapper genresMapper;

  public GenresService(GenresRepo genresRepo, GenresMapper genresMapper) {
    this.genresRepo = genresRepo;
    this.genresMapper = genresMapper;
  }

  public List<GenresDto> getAllGenres() {
    return genresMapper.toDtoList(genresRepo.findAll());
  }

  public GenresDto getGenreById(Short id) throws EntityNotFoundException {
    Optional<Genre> result = genresRepo.findById(id);

    if (result.isEmpty()) {
      throw new EntityNotFoundException("Genre (" + id + ") not found");
    }

    return genresMapper.toDto(result.get());
  }

  public List<GenresDto> getGenresByName(String name) {
    Optional<List<Genre>> result = genresRepo.findByGenreNameContainingIgnoreCase(name);

    if (result.isEmpty() || result.get().isEmpty()) {
      throw new EntityNotFoundException("Genre(s) with name (" + name + ") not found");
    }

    return genresMapper.toDtoList(result.get());
  }

  public GenresDto createGenre(GenresDto genresDto) {
    Genre genre = genresMapper.toEntity(genresDto);
    Genre saved = genresRepo.save(genre);
    return genresMapper.toDto(saved);
  }

  public GenresDto updateGenre(Short id, GenresDto genresDto) {
    Genre genre = genresRepo
        .findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Genre (" + id + ") not found"));

    genre.setGenreName(genresDto.getGenreName());
    Genre saved = genresRepo.save(genre);
    return genresMapper.toDto(saved);
  }
}
