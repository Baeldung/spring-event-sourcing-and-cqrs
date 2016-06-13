package com.baeldung.scoring.projection;

import org.springframework.stereotype.Component;

import com.baeldung.infra.projection.AbstractProjectionPoller;

@Component
public class ScoringPoller extends AbstractProjectionPoller {

    public ScoringPoller() {
        super();
    }

}
