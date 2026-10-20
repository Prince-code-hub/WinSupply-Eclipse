package com.winsupply.bookish.repository;

import com.winsupply.bookish.model.Book;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {

  Optional<List<Book>> findByTitle(String title);
}
