package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.GenresDto;
import com.winsupply.bookish.service.GenresService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenresController {

  private final GenresService genreService;

  public GenresController(GenresService genreService) {
    this.genreService = genreService;
  }

  @GetMapping
  public List<GenresDto> getAllGenres() {
    return genreService.getAllGenres();
  }

  @GetMapping("/{id}")
  public GenresDto getGenreById(@PathVariable Short id) {
    return genreService.getGenreById(id);
  }

  @GetMapping("/search")
  public List<GenresDto> getGenresByName(@RequestParam String name) {
    return genreService.getGenresByName(name);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GenresDto createGenre(@RequestBody GenresDto genresDto) {
    return genreService.createGenre(genresDto);
  }

  @PutMapping("/{id}")
  public GenresDto updateGenre(@PathVariable Short id, @RequestBody GenresDto genresDto) {
    return genreService.updateGenre(id, genresDto);
  }
}
