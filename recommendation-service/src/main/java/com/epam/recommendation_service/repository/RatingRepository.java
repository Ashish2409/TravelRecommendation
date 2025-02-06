package com.epam.recommendation_service.repository;

import com.epam.recommendation_service.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByBlogId(Integer blogId);
    Optional<Rating> findByBlogIdAndUserEmail(Integer blogId, String userEmail);
}
