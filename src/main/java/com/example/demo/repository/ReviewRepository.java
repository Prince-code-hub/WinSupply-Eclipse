package com.example.demo.repository;

import com.example.demo.model.Review;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
  Optional<List<Review>> findByReviewTextContainingIgnoreCase(String text);
}
