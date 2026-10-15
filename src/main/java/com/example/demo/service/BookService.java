package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepo bookRepo;

  // gets all books
  public List<Book> getAllBooks() {
    return bookRepo.findAll();
  }

  // gets book id
  public Book getBookById(Integer id) throws EntityNotFoundException {

    Optional<Book> result = bookRepo.findById(id);

    if (result.isEmpty()) {
      throw new EntityNotFoundException("Book (" + id + ") not found");
    }

    return result.get();
  }

  // gets book title
  public List<Book> getBooksByTitle(String title) {

    Optional<List<Book>> result = bookRepo.findByTitle(title);

    if (result.isEmpty() || result.get().isEmpty()) {
      throw new EntityNotFoundException("Book(s) with title (" + title + ") not found");
    }

    return result.get();
  }
}
