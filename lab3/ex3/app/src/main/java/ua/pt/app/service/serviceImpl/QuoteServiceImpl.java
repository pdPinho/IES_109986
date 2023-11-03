package ua.pt.app.service.serviceImpl;

import lombok.AllArgsConstructor;
import ua.pt.app.entity.Quote;
import ua.pt.app.repository.QuoteRepository;
import ua.pt.app.service.QuoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getQuoteById(Long quoteId) {
        Optional<Quote> optionalQuote = quoteRepository.findById(quoteId);
        return optionalQuote.get();
    }

    @Override
    public Quote getRandomQuote(){
        int size = getAllQuotes().size();
        Random rand = new Random();

        int id = rand.nextInt(size) + 1; 

        return getQuoteById((long) id);
    }

    @Override
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();
    }

    @Override
    public Quote updateQuote(Quote quote) {
        Quote existingQuote = quoteRepository.findById(quote.getId()).get();
        existingQuote.setQuote(quote.getQuote());
        Quote updatedQuote = quoteRepository.save(existingQuote);
        return updatedQuote;
    }

    @Override
    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }
}