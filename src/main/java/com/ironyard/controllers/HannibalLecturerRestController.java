package com.ironyard.controllers;

import com.ironyard.entities.Lecturer;
import com.ironyard.entities.Review;
import com.ironyard.services.LecturerRepository;
import com.ironyard.services.ReviewRepository;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

/**
 * Created by illladell on 7/1/16.
 */

@RestController
public class HannibalLecturerRestController {

    @Autowired
    LecturerRepository lecturers;

    @Autowired
    ReviewRepository reviews;

    @PostConstruct
    public void init() throws SQLException {
        Server.createWebServer().start();
    }


    @RequestMapping(path = "/lecturers", method = RequestMethod.POST)
    public void lecturers(String name, String topic, String image) {
        Lecturer lecturer = new Lecturer(name, topic, image);
        lecturers.save(lecturer);
    }

    @RequestMapping(path = "/lecturers", method = RequestMethod.GET)
    public Iterable<Lecturer> lecturersGet() {
        return lecturers.findAll();
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public void reviews(String author, String text, int lecturerId, boolean isGood) {
        Lecturer lecturer = lecturers.findOne(lecturerId);
        Review review = new Review(author, text, isGood, lecturer);
        reviews.save(review);
    }

    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> reviewsGet() {
        return reviews.findAll();
    }
}
