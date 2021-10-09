package com.movieWorld.service;

import com.movieWorld.exceptions.RecordNotFoundException;
import com.movieWorld.model.Movie;
import com.movieWorld.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    MongoTemplate mongoTemplate;

    public List<Movie> getMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(String id) {
        return repository.findById(id).orElseThrow(
                () -> new RecordNotFoundException("Movie by Id " + id + " not found!"));
    }

    public Movie getMovieByName(String name) {
        return repository.findMovieByName(name).orElseThrow(
                () -> new RecordNotFoundException("Movie by Name " + name + " not found!"));
    }

    public List<Movie> filterMovies(Map<String, String> filters) {

        Query query = generateQuery(filters);

        return mongoTemplate.find(query, Movie.class);
    }

    private Query generateQuery(Map<String, String> filters) {
        Query query = new Query();
        List<Criteria> criteria = checkFilter(filters);
        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        return query;
    }

    private List<Criteria> checkFilter(Map<String, String> filters) {
        List<Criteria> criteria = new ArrayList<>();
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String filterName = entry.getKey();
            String filterValue = entry.getValue();
            if (filterValue != null && !filterValue.isEmpty())
                criteria.add(Criteria.where(filterName).is(filterValue));
        }
        return criteria;
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
