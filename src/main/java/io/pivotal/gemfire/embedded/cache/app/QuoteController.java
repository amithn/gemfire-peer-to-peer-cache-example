package io.pivotal.gemfire.embedded.cache.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuoteController {

    private QuoteService quoteService = null;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @RequestMapping(value = "/quotes/{id}", method = RequestMethod.GET)
    @ResponseBody
    public QuoteResponseDTO quote(@PathVariable("id") Long quoteId) throws InterruptedException {
        quoteService.setCacheMissStatus(false);
        Quote quote = quoteService.requestQuote(quoteId);
        System.out.println("Quote for id " + quoteId + " is " + quote.getRandomName() + " cache miss? is "
                + quoteService.isCacheMiss());
        return new QuoteResponseDTO(quote, !quoteService.isCacheMiss());
    }

    @RequestMapping(value = "/quotes", method = RequestMethod.PUT)
    public void update(Quote quote) {
        quoteService.updateQuote(quote);
    }
}
