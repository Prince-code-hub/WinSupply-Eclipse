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
    private Integer bookId;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @Column(name = "Author", length = 50, nullable = false)
    private String author;

    @JoinColumn(name = "GenreID", nullable = false)
    @ManyToOne
    private Genre genre;

    @Column(name = "PageCount", nullable = false)
    private Short pageCount;

    @Column(name = "DatePosted", nullable = false)
    private LocalDate datePosted;
}
