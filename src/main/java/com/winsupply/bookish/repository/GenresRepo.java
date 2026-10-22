package com.winsupply.bookish.repository;

import com.winsupply.bookish.model.Genre;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenresRepo extends JpaRepository<Genre, Short> {
  Optional<List<Genre>> findByGenreNameContainingIgnoreCase(String genreName);
}
