package com.example.gtics_lab8_20212607.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idMovie;


    @Column(name = "title")
    private String title;

    @Column(name = "overview")
    private String overview;


    @Column(name = "release_date")
    private String release_date;


    @Column(name = "popularity")
    private Float popularity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
