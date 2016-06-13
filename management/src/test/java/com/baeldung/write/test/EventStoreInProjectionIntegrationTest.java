package com.baeldung.write.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.infra.persistence.event.RawEvent;
import com.baeldung.management.persistence.model.Lead;
import com.baeldung.management.persistence.repo.LeadRepo;
import com.baeldung.management.spring.ManagementProjectionApp;
import com.baeldung.management.spring.ManagementProjectionPersistenceConfig;
import com.baeldung.store.events.LeadCreated;
import com.baeldung.store.repo.RawEventRepo;
import com.baeldung.store.spring.EventStorePersistenceConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ManagementProjectionApp.class, ManagementProjectionPersistenceConfig.class, EventStorePersistenceConfig.class })
public class EventStoreInProjectionIntegrationTest {

    @Autowired
    private RawEventRepo rawEventRepo;

    @Autowired
    private LeadRepo leadRepo;

    // tests

    @Test
    public final void whenRetrievingAnEventByCorrelationId_thenNoFail() {
        final UUID correlationId = UUID.randomUUID();
        rawEventRepo.findOneByCorrelationId(correlationId);
    }

    @Test
    public final void whenSavingRawEvent_thenCanBeRetrieved() {
        final UUID correlationId = UUID.randomUUID();
        final RawEvent rawEvent = new RawEvent(correlationId, randomAlphabetic(12), LeadCreated.class.getCanonicalName());
        rawEventRepo.save(rawEvent);

        final RawEvent savedEvent = rawEventRepo.findAllByCorrelationId(correlationId).get(0);

        assertThat(savedEvent, equalTo(rawEvent));
    }

    //

    @Test
    public final void whenRetrievingALeadByName_thenNoFail() {
        leadRepo.findOneByName(randomAlphabetic(6));
    }

    @Test
    public final void whenSavingLead_thenCanBeRetrieved() {
        final String name = randomAlphabetic(12);
        final Lead lead = new Lead(UUID.randomUUID(), name);
        leadRepo.save(lead);

        final Lead savedLead = leadRepo.findOneByName(name);

        assertThat(savedLead, equalTo(lead));
    }

}
