package com.example.demo.controller;

import com.example.demo.dto.BookDto;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
    path = "book",
    produces = MediaType.APPLICATION_JSON_VALUE
)
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookMapper bookMapper;

    // GET all books
    @GetMapping
    ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(
            bookMapper.toDtoList(bookService.getAllBooks()), HttpStatus.OK);
    }

    // GET book by ID
    @GetMapping(path = "{id}")
    ResponseEntity<BookDto> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(
            bookMapper.toDto(bookService.getBookById(id)), HttpStatus.OK);
    }

    // GET books by title
    @GetMapping(path = "search")
    ResponseEntity<List<BookDto>> getBooksByTitle(@RequestParam String title) {
        return new ResponseEntity<>(
            bookMapper.toDtoList(bookService.getBooksByTitle(title)),
            HttpStatus.OK);
    }
}