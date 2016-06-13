package com.baeldung.write.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.infra.persistence.event.RawEvent;
import com.baeldung.management.spring.ManagementProjectionApp;
import com.baeldung.management.spring.ManagementProjectionPersistenceConfig;
import com.baeldung.store.events.LeadCreated;
import com.baeldung.store.repo.RawEventRepo;
import com.baeldung.store.service.EventStore;
import com.baeldung.store.spring.EventStorePersistenceConfig;
import com.baeldung.store.spring.EventsConfig;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ManagementProjectionApp.class, ManagementProjectionPersistenceConfig.class, EventStorePersistenceConfig.class, EventsConfig.class })
public class SudoManagementProjectionIntegrationTest {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private RawEventRepo rawEventRepo;

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenCorrect() {
        //
    }

    @Test
    public final void givenRawEventExists_whenRetrieving_thenCastWorks() throws JsonParseException, JsonMappingException, IOException, ClassNotFoundException {
        final UUID correlationId = UUID.randomUUID();
        eventStore.save(new LeadCreated(correlationId, UUID.randomUUID(), randomAlphabetic(8)));
        final RawEvent rawEvent = rawEventRepo.findAllByCorrelationId(correlationId).get(0);

        new ObjectMapper().readValue(rawEvent.getPayload(), Class.forName(rawEvent.getType()));
    }

}
