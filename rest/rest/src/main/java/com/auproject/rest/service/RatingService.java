package com.auproject.rest.service;

import com.auproject.rest.dao.Rating;
import com.auproject.rest.repository.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    public Boolean addRating(Rating rating) {
        try {
            this.ratingRepo.save(rating);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
