package com.example.restservice;

import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private final moviesQuotes moviesQuotes = new moviesQuotes();

	@GetMapping("/api/quote")
	public Quote quote() {
		Random rand = new Random();
		return moviesQuotes.getQuotes().get(rand.nextInt(0, moviesQuotes.getQuotes().size()));
	}

	
	@GetMapping("/api/show")
	public Collection<Shows> shows(){
		return moviesQuotes.getShows();
	}

	
	@GetMapping("/api/quotes")
	public List<String> quote(@RequestParam(value = "show") long show) {
		return moviesQuotes.getShowQuotes(show);
	}
}