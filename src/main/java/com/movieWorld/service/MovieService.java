package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.generic.GenericService;
import com.movieWorld.model.Movie;
import com.movieWorld.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MovieService extends GenericService {

    private final MovieRepository repository;

    MongoTemplate mongoTemplate;

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(String id) {
        return repository.findById(id).orElseThrow(() -> new RecordNotFoundException("Movie by Id " + id + " not found!"));
    }

    public Movie getMovieByName(String name) {
        return repository.findMovieByName(name).orElseThrow(() -> new RecordNotFoundException("Movie by Name " + name + " not found!"));
    }

    public List<Movie> filterMovies(Map<String, String> filters) {
        Query query = generateQuery(filters);
        return mongoTemplate.find(query, Movie.class);
    }

    public Movie addMovie(Movie movie) {
        return repository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        return repository.save(movie);
    }

    public void deleteMovie(String id) {
        repository.deleteById(id);
    }

}
