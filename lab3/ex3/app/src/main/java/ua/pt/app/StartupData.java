package ua.pt.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ua.pt.app.entity.Movie;
import ua.pt.app.entity.Quote;
import ua.pt.app.service.MovieService;
import ua.pt.app.service.QuoteService;


@Component
public class StartupData implements CommandLineRunner {
    private final MovieService movieService;
    private final QuoteService quoteService;

    @Autowired
    public StartupData(MovieService movieService, QuoteService quoteService){
        this.movieService = movieService;
        this.quoteService = quoteService;
    }

    @Override
    public void run(String... args){
        if (movieService.getAllMovies().size() == 0){
            addMovies();
            addQuotes();
        }
    }

    private void addMovies(){
        String title = "Toy Story";
        String year = "1995";
        
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();
        Movie movie3 = new Movie();

        movie1.setTitle(title);
        movie1.setYear(year);
        
        title = "The Dark Knight";
        year = "2008";
        movie2.setTitle(title);
        movie2.setYear(year);

        title = "Whiplash";
        year = "2014";
        movie3.setTitle(title);
        movie3.setYear(year);

        movieService.createMovie(movie1);
        movieService.createMovie(movie2);
        movieService.createMovie(movie3);
    }

    private void addQuotes(){
        String quote = "This isn't flying. This is falling with style!";
        Movie movie = movieService.getMovieById((long) 1);

        Quote quote1 = new Quote();
        Quote quote2 = new Quote();
        Quote quote3 = new Quote();
        Quote quote4 = new Quote();
        Quote quote5 = new Quote();

        quote1.setQuote(quote);
        quote1.setMovie(movie);

        quote = "You are a toy!";

        quote2.setQuote(quote);
        quote2.setMovie(movie);

        quote = "Reach for the sky!";

        quote3.setQuote(quote);
        quote3.setMovie(movie);


        quote = "Let's put a smile on that face!";
        movie = movieService.getMovieById((long) 2);

        quote4.setQuote(quote);
        quote4.setMovie(movie);

        quote = "There are no two words in the English language more harmful than good job";
        movie = movieService.getMovieById((long) 3);

        quote5.setQuote(quote);
        quote5.setMovie(movie);

        quoteService.createQuote(quote1);
        quoteService.createQuote(quote2);
        quoteService.createQuote(quote3);
        quoteService.createQuote(quote4);
        quoteService.createQuote(quote5);
    }
}
