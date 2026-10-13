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
    private Integer reviewId;

    @JoinColumn(name = "BookID", nullable = false)
    @ManyToOne
    private Book book;

    @Column(name = "Rating",  nullable = false)
    private Byte rating;

    @Column(name = "ReviewText", length = 3500,  nullable = false)
    private String reviewText;

    @Column(name = "IsRecommended")
    private Boolean isRecommended;

    @Column(name = "DatePosted",  nullable = false)
    private LocalDateTime datePosted;
}
