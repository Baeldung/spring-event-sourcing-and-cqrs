package com.baeldung.write.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.baeldung.store.spring.EventsConfig;

@Configuration
@ComponentScan("com.baeldung.write.web")
@SpringBootApplication
public class CommandsApp extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        new SpringApplicationBuilder().sources(CommandsApp.class, EventsConfig.class).run(args);
    }

}
