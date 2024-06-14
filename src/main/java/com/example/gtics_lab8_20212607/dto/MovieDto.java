package com.example.gtics_lab8_20212607.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private boolean adult;
    private String backdrop_path;
    private Integer id;
    private String original_language;
    private String original_title;
    private String overview;
    private float popularity;
    private String poster_path;
    private String release_date;
    private String title;
    private boolean video;
    private float vote_average;
    private Integer vote_count;
    private Integer[] genre_ids;




}
