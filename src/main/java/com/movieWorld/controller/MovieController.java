package com.movieWorld.controller;

import com.movieWorld.model.Movie;
import com.movieWorld.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getMovies(){
        List<Movie> movies = movieService.getMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") String id){
        Movie movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie (@RequestBody Movie newMovie){
        Movie movie = movieService.addMovie(newMovie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Movie> updateMovie (@RequestBody Movie newMovie){
        Movie movie = movieService.updateMovie(newMovie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Movie> deleteMovie (@PathVariable("id") String id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
