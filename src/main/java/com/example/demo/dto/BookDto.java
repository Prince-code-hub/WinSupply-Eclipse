package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDate;
import com.example.demo.model.Genre;

@Data
public class BookDto {

    Integer bookId;
    String title;
    Integer genreId;
    Short pageCount;
    LocalDate datePosted;
}