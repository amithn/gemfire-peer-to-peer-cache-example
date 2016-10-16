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

}
