package com.baeldung.infra.event;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseEvent implements Serializable {

    private static final long serialVersionUID = 1;

    /**
     * This ID is the same for all events committed in the same transaction.
     */
    private UUID correlationId;

    protected BaseEvent() {
        super();
    }

    protected BaseEvent(final UUID correlationId) {
        super();

        this.correlationId = correlationId;
    }

    //

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(final UUID correlationId) {
        this.correlationId = correlationId;
    }

}
