package com.winsupply.bookish.service;

import com.winsupply.bookish.model.Book;
import com.winsupply.bookish.model.Genre;
import com.winsupply.bookish.repository.BookRepo;
import com.winsupply.bookish.repository.GenresRepo;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepo bookRepo;
  private final GenresRepo genresRepo;

  public BookService(BookRepo bookRepo, GenresRepo genresRepo) {
    this.bookRepo = bookRepo;
    this.genresRepo = genresRepo;
  }

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

  // creates a new book with an existing genre
  public Book createBook(Book book, Integer genreId) {

    if (genreId == null || genreId < 1 || genreId > Short.MAX_VALUE) {
      throw new IllegalArgumentException("Invalid genre ID");
    }

    Genre genre = genresRepo
        .findById(genreId.shortValue())
        .orElseThrow(() -> new EntityNotFoundException("Genre (" + genreId + ") not found"));

    book.setGenre(genre);

    return bookRepo.save(book);
  }
}
