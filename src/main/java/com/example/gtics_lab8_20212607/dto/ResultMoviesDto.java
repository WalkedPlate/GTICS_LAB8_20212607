package com.example.gtics_lab8_20212607.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResultMoviesDto {

    private Integer page;
    private Dates dates;
    private MovieDto[] results;


    @Getter
    @Setter
    public static class Dates{
        private String maximun;
        private String minimun;

    }

}
