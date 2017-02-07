package com.innoq.mploed.ddd.creditAgency.controller;

import com.innoq.mploed.ddd.creditAgency.RatingService;
import com.innoq.mploed.ddd.creditAgency.domain.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRatingControlloer {
    private RatingService ratingService;

    @Autowired
    public PersonRatingControlloer(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/personRating")
    public Rating ratePerson(
            @RequestParam(value = "firstName", defaultValue = "") String firstName,
            @RequestParam(value = "lastName", defaultValue = "") String lastName,
            @RequestParam(value = "street", defaultValue = "") String street,
            @RequestParam(value = "postCode", defaultValue = "") String postCode
    ) {
        return ratingService.getRating(street, postCode);

    }


}
