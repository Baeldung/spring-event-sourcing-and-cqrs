package com.baeldung.scoring.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.baeldung.store.spring.EventStorePersistenceConfig;

@SpringBootApplication
@ComponentScan("com.baeldung.scoring")
@EnableScheduling
public class ScoringProjectionApp extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        new SpringApplicationBuilder().sources( //@formatter:off
                ScoringProjectionApp.class,
                EventStorePersistenceConfig.class,
                ScoringProjectionPersistenceConfig.class
        ).run(args); // @formatter:on
    }

}
