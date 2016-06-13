package com.baeldung.management.projection;

import org.springframework.stereotype.Component;

import com.baeldung.infra.projection.AbstractProjectionPoller;

@Component
public class ManagementPoller extends AbstractProjectionPoller {

    public ManagementPoller() {
        super();
    }

}
