package com.winsupply.bookish.controller;

import com.winsupply.bookish.dto.BookDto;
import com.winsupply.bookish.mapper.BookMapper;
import com.winsupply.bookish.service.BookService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

  private final BookService bookService;
  private final BookMapper bookMapper;

  public BookController(BookService bookService, BookMapper bookMapper) {
    this.bookService = bookService;
    this.bookMapper = bookMapper;
  }

  // GET all books
  @GetMapping
  ResponseEntity<List<BookDto>> getAllBooks() {
    return new ResponseEntity<>(bookMapper.toDtoList(bookService.getAllBooks()), HttpStatus.OK);
  }

  // GET book by ID
  @GetMapping(path = "{id}")
  ResponseEntity<BookDto> getBookById(@PathVariable Integer id) {
    return new ResponseEntity<>(bookMapper.toDto(bookService.getBookById(id)), HttpStatus.OK);
  }

  // GET books by title
  @GetMapping(path = "search")
  ResponseEntity<List<BookDto>> getBooksByTitle(@RequestParam String title) {
    return new ResponseEntity<>(
        bookMapper.toDtoList(bookService.getBooksByTitle(title)), HttpStatus.OK);
  }
}
