package com.example.gtics_lab8_20212607.repository;

import com.example.gtics_lab8_20212607.entity.Movie;
import com.example.gtics_lab8_20212607.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findByUser(User user);

}
