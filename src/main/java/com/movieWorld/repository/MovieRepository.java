package com.movieWorld.repository;

import com.movieWorld.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends MongoRepository <Movie, String> {

    Optional <Movie> findMovieByName(String name);

    @Query(value = "{$and :[{name: ?0},{country: ?1}]}")
    Optional<List<Movie>> filterMovies(@Param("name") String name, @Param("country") String country);

}
