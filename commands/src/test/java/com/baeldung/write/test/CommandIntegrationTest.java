package com.baeldung.write.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.store.events.LeadCreated;
import com.baeldung.store.spring.EventsConfig;
import com.baeldung.write.spring.CommandsApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CommandsApp.class, EventsConfig.class })
public class CommandIntegrationTest {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    // tests

    @Test
    public final void whenPublishingLeadCreatedEvent_thenCorrect() {
        eventPublisher.publishEvent(new LeadCreated(UUID.randomUUID(), UUID.randomUUID(), randomAlphabetic(8)));
    }

}
