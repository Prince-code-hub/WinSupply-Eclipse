package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.GenreDto;
import com.winsupply.bookish.service.GenreService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreController {

  private final GenreService genreService;

  public GenreController(GenreService genreService) {
    this.genreService = genreService;
  }

  @GetMapping
  public List<GenreDto> getAllGenres() {
    return genreService.getAllGenres();
  }

  @GetMapping("/{id}")
  public GenreDto getGenreById(@PathVariable Short id) {
    return genreService.getGenreById(id);
  }

  @GetMapping("/search")
  public List<GenreDto> getGenresByName(@RequestParam String name) {
    return genreService.getGenresByName(name);
  }
}
