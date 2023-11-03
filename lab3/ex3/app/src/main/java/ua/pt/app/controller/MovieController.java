package ua.pt.app.controller;

import lombok.AllArgsConstructor;
import ua.pt.app.entity.Movie;
import ua.pt.app.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie savedMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long movieId){
        Movie movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies;
        movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long movieId,
                                           @RequestBody Movie movie){
        movie.setId(movieId);
        Movie updatedMovie = movieService.updateMovie(movie);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable("id") Long movieId){
        movieService.deleteMovie(movieId);
        return new ResponseEntity<>("Movie successfully deleted!", HttpStatus.OK);
    }
}