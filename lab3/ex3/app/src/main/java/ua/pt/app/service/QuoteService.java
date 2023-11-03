package ua.pt.app.service;

import ua.pt.app.entity.Quote;

import java.util.List;

public interface QuoteService {
    Quote createQuote(Quote quote);

    Quote getQuoteById(Long quoteId);

    Quote getRandomQuote();

    List<Quote> getAllQuotes();

    Quote updateQuote(Quote quote);

    void deleteQuote(Long quoteId);
}