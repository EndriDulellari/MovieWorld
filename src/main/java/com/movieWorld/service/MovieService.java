package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Movie;
import com.movieWorld.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(String id){
        return movieRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Movie by Id " + id + " not found!"));
    }
    public Movie getMovieByName(String name){
        return movieRepository.findMovieByName(name).orElseThrow(
                () -> new RecordNotFoundException("Movie by Name " + name + " not found!"));
    }

    public Movie addMovie (Movie movie){
       return movieRepository.save(movie);
    }

    public Movie updateMovie (Movie movie){
        return movieRepository.save(movie);
    }

    public void deleteMovie(String id){
        movieRepository.deleteById(id);
    }

}
