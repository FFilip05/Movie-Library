package com.FFilip05.SimpleMovieLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

//    @GetMapping
//    public String getMoviesToTemplate(Model model){
////        model.addAttribute("movies", Arrays.asList(getAllMovies()));
//                model.addAttribute("people", Arrays.asList(
//                        new Movie(1,120,5,"StarWars")
//                ));
//
//        return "index";
//    }

    @GetMapping
    String getPeople(Model model){
        model.addAttribute("people", Arrays.asList(
                new Movie(1,120,5,"StarWars")
        ));

        return "people";
    }

    @GetMapping("/")
    public List<Movie> getAllMovies() {

        return movieRepository.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") int id){

        return movieRepository.getMovieById(id);
    }
    @PostMapping("/")
    public int addMovie(@RequestBody List<Movie> movies) {

        return movieRepository.saveMovie(movies);
    }
    @PutMapping("/{id}")
    public int updateMovie(@PathVariable("id") int id,@RequestBody Movie updatedMovie){
        Movie movie = movieRepository.getMovieById(id);
        if (movie != null){
            movie.setTitle(updatedMovie.getTitle());
            movie.setLength(updatedMovie.getLength());
            movie.setRating(updatedMovie.getRating());
            return 1;
        } else {
            return -1;
        }
    }
    @DeleteMapping
    public int  deleteMovieById(@PathVariable("id") int id){
        return movieRepository.delete(id);
    }
}
