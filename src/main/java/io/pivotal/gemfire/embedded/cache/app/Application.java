package io.pivotal.gemfire.embedded.cache.app;


import org.kohsuke.randname.RandomNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;


@SpringBootApplication(scanBasePackages = {"io.pivotal.gemfire.embedded.cache.app"})
@EnableCaching
@EnableScheduling
@SuppressWarnings("unused")
public class Application {

    private final RandomNameGenerator randomNameGenerator;
    private QuoteService quoteService;

    public Application(QuoteService quoteService, RandomNameGenerator randomNameGenerator) {
        this.quoteService = quoteService;
        this.randomNameGenerator = randomNameGenerator;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Scheduled(fixedDelay = 30000, initialDelay = 10000)
//    public void scheduledUpdate() {
//        Long number = Integer.toUnsignedLong(new Random().nextInt(10));
//        String next = randomNameGenerator.next();
//        System.out.println("Number which was just updated is " + number + " -> " + next);
//        quoteService.updateQuote(new Quote(number, next));
//    }

}
