package com.auproject.rest.controller;


import com.auproject.rest.dao.Rating;
import com.auproject.rest.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/answer/rating")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> addRating(@RequestBody Rating rating){
        return new ResponseEntity<>(this.ratingService.addRating(rating), HttpStatus.OK);
    }
}
