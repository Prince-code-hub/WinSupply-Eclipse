package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID", nullable = false)
    Integer reviewId;

    @JoinColumn(name = "BookID", nullable = false)
    @ManyToOne
    Book book;

    @Column(name = "Rating",  nullable = false)
    Byte rating;

    @Column(name = "ReviewText", length = 3500,  nullable = false)
    String reviewText;

    @Column(name = "IsRecommended")
    Boolean isRecommended;

    @Column(name = "DatePosted",  nullable = false)
    LocalDateTime datePosted;
}
