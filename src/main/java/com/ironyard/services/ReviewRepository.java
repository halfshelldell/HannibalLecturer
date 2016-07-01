package com.ironyard.services;

import com.ironyard.entities.Review;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by illladell on 7/1/16.
 */
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
