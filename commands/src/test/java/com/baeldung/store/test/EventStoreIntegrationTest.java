package com.baeldung.store.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.store.events.LeadCreated;
import com.baeldung.store.repo.RawEventRepo;
import com.baeldung.store.service.EventStore;
import com.baeldung.store.spring.EventsConfig;
import com.baeldung.write.spring.CommandsApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CommandsApp.class, EventsConfig.class })
public class EventStoreIntegrationTest {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private RawEventRepo rawEventRepo;

    // tests

    @Test
    public final void whenPersistingLeadCreatedEvent_thenCorrect() {
        final UUID correlationId = UUID.randomUUID();
        eventStore.save(new LeadCreated(correlationId, UUID.randomUUID(), randomAlphabetic(8)));

        assertThat(rawEventRepo.findOneByCorrelationId(correlationId), notNullValue());
    }

}
