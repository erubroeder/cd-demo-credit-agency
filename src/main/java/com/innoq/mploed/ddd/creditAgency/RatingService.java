package com.innoq.mploed.ddd.creditAgency;

import com.innoq.mploed.ddd.creditAgency.domain.Rating;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RatingService {
    public Rating getRating(String street, String postCode) {
        int points = 0;

        Rating rating = new Rating();

        if(postCode.startsWith("8")) {
            points += 110;
        } else if(postCode.startsWith("90")) {
            points += 115;
        } else if(postCode.startsWith("40")) {
            points += 15;
        }

        if(street.contains("Kreuz")) {
            points += 20;
        }

        rating.setPoints(points);
        if(points == 20) {
            rating.setColor("RED");
        } else if(points == 100) {
            rating.setColor("YELLOW");
        } else if(points > 100){
            rating.setColor("GREEN");
        } else {
            rating.setColor("BLACK");
        }


        return rating;
    }
}
