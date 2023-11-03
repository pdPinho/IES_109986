package ua.pt.app.controller;

import lombok.AllArgsConstructor;
import ua.pt.app.entity.Quote;
import ua.pt.app.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/quotes")
public class QuoteController {

    private QuoteService quoteService;

    @PostMapping
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote){
        Quote savedQuote = quoteService.createQuote(quote);
        return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
    }

    @GetMapping("random")
    public ResponseEntity<Quote> getRandomQuote(){
        Quote quote = quoteService.getRandomQuote();
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable("id") Long quoteId){
        Quote quote = quoteService.getQuoteById(quoteId);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<Quote>> getAllQuotes(){
        List<Quote> quotes;
        quotes = quoteService.getAllQuotes();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Quote> updateQuote(@PathVariable("id") Long quoteId,
                                           @RequestBody Quote quote){
        quote.setId(quoteId);
        Quote updatedQuote = quoteService.updateQuote(quote);
        return new ResponseEntity<>(updatedQuote, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuote(@PathVariable("id") Long quoteId){
        quoteService.deleteQuote(quoteId);
        return new ResponseEntity<>("Quote successfully deleted!", HttpStatus.OK);
    }
}