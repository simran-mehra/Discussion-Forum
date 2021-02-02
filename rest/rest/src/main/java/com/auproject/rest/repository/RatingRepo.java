package com.auproject.rest.repository;

import com.auproject.rest.dao.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
}
