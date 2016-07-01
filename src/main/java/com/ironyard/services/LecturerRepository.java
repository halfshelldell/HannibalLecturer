package com.ironyard.services;

import com.ironyard.entities.Lecturer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by illladell on 7/1/16.
 */
public interface LecturerRepository extends CrudRepository<Lecturer, Integer> {
}
