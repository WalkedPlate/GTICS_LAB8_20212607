package com.example.gtics_lab8_20212607.controller;

import com.example.gtics_lab8_20212607.dao.MoviesDao;
import com.example.gtics_lab8_20212607.dto.MovieDto;
import com.example.gtics_lab8_20212607.entity.Movie;
import com.example.gtics_lab8_20212607.entity.User;
import com.example.gtics_lab8_20212607.repository.MovieRepository;
import com.example.gtics_lab8_20212607.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MoviesController {

    @Autowired
    MoviesDao moviesDao;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MovieRepository movieRepository;


    @GetMapping({"/list", "", "/"})
    public String listarPeliculas(Model model) {

        model.addAttribute("listaPeliculas", moviesDao.listarPeliculas());
        return "list";
    }

    @GetMapping({"/fav"})
    public String listarPeliculasFavoritas(Model model) {

        //No hay lógica de session/ trabajamos con el usuario 1
        User user = userRepository.findById(1).get();
        List<Movie> listaFavs = movieRepository.findByUser(user);

        model.addAttribute("listaPeliculas", listaFavs);
        return "fav";
    }

    @PostMapping("/agregar")
    public String guardar(@RequestParam("id") Integer id,
                          RedirectAttributes attr,
                          Model model) {

        //Lógica sin session
        User user = userRepository.findById(1).get();

        List<MovieDto> listaPeliculas = moviesDao.listarPeliculas();
        Movie movieBd = new Movie();

        for(MovieDto pel : listaPeliculas){
            if (id == pel.getId()){
                movieBd.setUser(user);
                movieBd.setOverview(pel.getOverview());
                movieBd.setTitle(pel.getTitle());
                movieBd.setPopularity(pel.getPopularity());
                movieBd.setRelease_date(pel.getRelease_date());

                movieRepository.save(movieBd);
                attr.addFlashAttribute("msg", "Pelicula agregada correctamente");
                return "redirect:/list";
            }

        }
        return "redirect:/list";

    }
}
