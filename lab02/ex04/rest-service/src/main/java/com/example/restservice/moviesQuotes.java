package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

public class moviesQuotes {
    private ArrayList<Quote> quotes = new ArrayList<>();
    private ArrayList<Shows> shows = new ArrayList<>();
    private HashMap<String, List<String>> showsQuotes = new HashMap<>();
    private static final AtomicLong counter = new AtomicLong();

    public moviesQuotes(){
        populateQuotes();
        populateShows();
        populateShowsQuotes();
    }

    public void populateQuotes(){
        quotes.add(new Quote("This isn't flying. This is falling with style!", "Toy Story (1995)"));
        quotes.add(new Quote("You are a toy!", "Toy Story (1995)"));
		quotes.add(new Quote("Reach for the sky!", "Toy Story (1995)"));
		quotes.add(new Quote("Let's put a smile on that face!", "The Dark Knight (2008)"));
		quotes.add(new Quote("We accept the love we think we deserve", "The Perks of Being a Wallflower. (2012)"));
		quotes.add(new Quote("There are no two words in the English language more harmful than good job", "Whiplash (2014)"));
    }

    public void populateShows(){
		shows.add(new Shows(counter.getAndIncrement(), "Toy Story (1995)"));
		shows.add(new Shows(counter.getAndIncrement(), "The Dark Knight (2008)"));
		shows.add(new Shows(counter.getAndIncrement(), "The Perks of Being a Wallflower. (2012)"));
		shows.add(new Shows(counter.getAndIncrement(), "Whiplash (2014)"));
    }

    public void populateShowsQuotes(){
        showsQuotes.put(shows.get(0).title(), Arrays.asList(quotes.get(0).quote(), 
                                                            quotes.get(1).quote(), 
                                                            quotes.get(2).quote()));
        showsQuotes.put(shows.get(1).title(), Arrays.asList(quotes.get(3).quote()));
        showsQuotes.put(shows.get(2).title(), Arrays.asList(quotes.get(4).quote()));
        showsQuotes.put(shows.get(3).title(), Arrays.asList(quotes.get(5).quote()));
    }

    public ArrayList<Quote> getQuotes(){
        return quotes;
    }

    public Collection<Shows> getShows(){
        return shows;
    }	

    public List<String> getShowQuotes(long id){
        String title = "";
        for (Shows show : shows) {
            if(show.id() == id){
                title = show.title();
                break;
            }
        }
        return showsQuotes.get(title);
    }
}
