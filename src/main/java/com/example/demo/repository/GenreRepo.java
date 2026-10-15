package com.example.demo.repository;

import com.example.demo.model.Genre;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Short> {
  Optional<List<Genre>> findByGenreNameContainingIgnoreCase(String genreName);
}
