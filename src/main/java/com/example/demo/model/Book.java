package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID", nullable = false)
    Integer bookId;

    @Column(name = "Title", length = 50, nullable = false)
    String title;

    @JoinColumn(name = "GenreID", nullable = false)
    @ManyToOne
    Genre genre;

    @Column(name = "PageCount", nullable = false)
    Short pageCount;

    @Column(name = "DatePosted", nullable = false)
    LocalDate datePosted;
}
