package io.pivotal.gemfire.embedded.cache.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"io.pivotal.gemfire.embedded.cache.app"})
@EnableCaching
@SuppressWarnings("unused")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
