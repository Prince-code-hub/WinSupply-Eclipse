package com.example.demo.repository;

import com.example.demo.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

  Optional<List<Book>> findByTitle(String title);
}
