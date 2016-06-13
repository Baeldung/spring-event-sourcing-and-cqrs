package com.baeldung.infra.projection;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;

import com.baeldung.infra.event.BaseEvent;
import com.baeldung.infra.persistence.event.RawEvent;
import com.baeldung.store.repo.RawEventRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractProjectionPoller {

    private ObjectMapper mapper;

    private Long lastProcessedId;

    @Autowired
    private RawEventRepo rawEventRepo;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    //

    @Scheduled(fixedRate = 1000)
    void readNewEvents() {
        rawEventRepo.findAll().stream().filter(ev -> (ev.getId() > lastProcessedId)).forEach(e -> processEvent(e));
    }

    //

    private final void processEvent(final RawEvent rawEvent) {
        BaseEvent event = null;
        try {
            event = (BaseEvent) mapper.readValue(rawEvent.getPayload(), Class.forName(rawEvent.getType()));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        event.setCorrelationId(rawEvent.getCorrelationId());

        lastProcessedId = rawEvent.getId();

        eventPublisher.publishEvent(event);
    }

    //

    @PostConstruct
    void instantiate() {
        this.mapper = new ObjectMapper();
        this.lastProcessedId = -1L;
    }

}
