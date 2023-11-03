package ua.pt.app.service;

import ua.pt.app.entity.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie getMovieById(Long movieId);

    List<Movie> getAllMovies();

    Movie updateMovie(Movie movie);

    void deleteMovie(Long movieId);
}