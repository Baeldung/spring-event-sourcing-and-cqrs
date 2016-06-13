package com.baeldung.store.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.baeldung.store")
public class EventsConfig {

    public EventsConfig() {
        super();
    }

}
