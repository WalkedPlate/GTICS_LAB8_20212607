package com.example.gtics_lab8_20212607.dao;

import com.example.gtics_lab8_20212607.dto.MovieDto;
import com.example.gtics_lab8_20212607.dto.ResultMoviesDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class MoviesDao {


    public List<MovieDto> listarPeliculas(){

        String url = "https://api.themoviedb.org/3/movie/now_playing";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0ZjcxYjY0NjI" +
                "xZGQ0NzJhMzk3MGI0MzE4Zjg4OTIyYSIsInN1YiI6IjY2NmI4Yjc0Zj" +
                "llMGQ5MWM4MDI0ODQ2NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJza" +
                "W9uIjoxfQ.HbmOUAxubsduw3QbWnwvcMaH3rBNsOLG8-cVKwOoN50";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ResultMoviesDto> responseMap = restTemplate.exchange(url, HttpMethod.GET, entity, ResultMoviesDto.class);

        return Arrays.asList(responseMap.getBody().getResults());

    }

    public MovieDto buscarPorId(Integer id){

        return new MovieDto();

    }

}
