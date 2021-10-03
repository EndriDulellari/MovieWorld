package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Actor;
import com.movieWorld.model.Movie;
import com.movieWorld.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(String id){
        return repository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Movie by Id " + id + " not found!"));
    }
    public Movie getMovieByName(String name){
        return repository.findMovieByName(name).orElseThrow(
                () -> new RecordNotFoundException("Movie by Name " + name + " not found!"));
    }
    public List<Movie> filterMovies(String name, String country) {
        return repository.filterMovies(name, country).orElseThrow(
                () -> new RecordNotFoundException("Movies not found!")
        );
    }

    public Movie addMovie (Movie movie){
       return repository.save(movie);
    }

    public Movie updateMovie (Movie movie){
        return repository.save(movie);
    }

    public void deleteMovie(String id){
        repository.deleteById(id);
    }

}
