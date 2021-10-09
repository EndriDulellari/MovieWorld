package com.movieWorld.repository;

import com.movieWorld.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {

    Optional<Movie> findMovieByName(String name);

}
