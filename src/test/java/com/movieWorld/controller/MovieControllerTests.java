package com.movieWorld.controller;

import com.movieWorld.model.Movie;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieControllerTests {

    @Autowired
    MovieController movieController;

    String movieId = "";
    ResponseEntity<Movie> responseEntity;
    ResponseEntity<List<Movie>> listResponseEntity;
    Movie newMovie = new Movie("Avengers", "The Asgardian Loki encounters the...", "$220 million", "$1.519 billion");
    List<Movie> movieList;
    Movie movie;

    @Test
    @Order(1)
    void test_addMovie() {
        responseEntity = movieController.addMovie(newMovie);
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("200 OK", responseEntity.getStatusCode().toString());

        movie = responseEntity.getBody();
        assertNotNull(movie);
        assertNotEquals("", movie.getId());
        movieId = movie.getId();
    }

    @Test
    @Order(2)
    void test_getMovies() {
        listResponseEntity = movieController.getMovies();
        assertNotNull(listResponseEntity);
        assertEquals(200, listResponseEntity.getStatusCodeValue());
        assertEquals("200 OK", listResponseEntity.getStatusCode().toString());

        movieList = listResponseEntity.getBody();
        assertNotNull(movieList);
        assertTrue(movieList.size() > 0);
    }

    @Test
    @Order(3)
    void test_getMovieById() {
        responseEntity = movieController.getMovieById(movieId);
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("200 OK", responseEntity.getStatusCode().toString());

        movie = responseEntity.getBody();
        assertNotNull(movie);
        assertEquals(movieId, movie.getId());
    }

    @Test
    @Order(4)
    void test_getMovieByName() {

        responseEntity = movieController.getMovieByName("Avengers");
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("200 OK", responseEntity.getStatusCode().toString());

        movie = responseEntity.getBody();
        assertNotNull(movie);
        assertEquals("Avengers", movie.getName());
    }

    @Test
    @Order(5)
    void test_filterMovies() {

        Map<String, String> filters = new HashMap<>();
        filters.put("budget", "$220 million");
        filters.put("boxOffice", "$1.519 billion");

        listResponseEntity = movieController.filterMovies(filters);
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("200 OK", responseEntity.getStatusCode().toString());

        movieList = listResponseEntity.getBody();
        assertNotNull(movieList);
        assertTrue(movieList.size() > 0);
    }

    @Test
    @Order(6)
    void test_updateMovie() {

        newMovie = new Movie("Avengers", "Updated", "$220 million", "$1.519 billion");
        responseEntity = movieController.updateMovie(newMovie);
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("200 OK", responseEntity.getStatusCode().toString());

        movie = responseEntity.getBody();
        assertNotNull(movie);
        assertEquals(movieId, movie.getId());
        assertEquals("Updated", movie.getPlot());
    }

    @Test
    @Order(7)
    void test_deleteMovie() {
        movieController.deleteMovie(movieId);
        try {
            responseEntity = movieController.getMovieById(movieId);
        } catch (Exception exception) {
            assertEquals("com.movieWorld.exceptions.RecordNotFoundException", exception.toString());
        }
    }
}