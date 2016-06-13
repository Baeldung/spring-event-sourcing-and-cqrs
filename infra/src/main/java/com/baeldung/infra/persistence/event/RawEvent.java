package com.baeldung.infra.persistence.event;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table
public class RawEvent implements Serializable {

    /**
     * Global, sequentially increasing number (coming from a global sequence)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Assigned by database, identical for all events saved in one transaction
     */
    @Column
    private OffsetDateTime transactionTime;

    /**
     * This ID is the same for all events committed in the same transaction.
     */
    @Column(nullable = false)
    private UUID correlationId;

    @Column(nullable = false)
    private String payload;

    @Column(nullable = false)
    private String type;

    public RawEvent() {
        super();
    }

    public RawEvent(final UUID correlationId, final String payload, final String type) {
        super();

        this.correlationId = correlationId;
        this.payload = payload;
        this.type = type;
    }

    //

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public OffsetDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(final OffsetDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public UUID getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(final UUID correlationId) {
        this.correlationId = correlationId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(final String payload) {
        this.payload = payload;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    //

    @Override
    public String toString() {
        return getClass().getSimpleName() + "#" + id;
    }

    //

    @PrePersist
    void onCreate() {
        this.setTransactionTime(OffsetDateTime.now());
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((correlationId == null) ? 0 : correlationId.hashCode());
        result = prime * result + ((payload == null) ? 0 : payload.hashCode());
        result = prime * result + ((transactionTime == null) ? 0 : transactionTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RawEvent other = (RawEvent) obj;
        if (correlationId == null) {
            if (other.correlationId != null)
                return false;
        } else if (!correlationId.equals(other.correlationId))
            return false;
        if (payload == null) {
            if (other.payload != null)
                return false;
        } else if (!payload.equals(other.payload))
            return false;
        if (transactionTime == null) {
            if (other.transactionTime != null)
                return false;
        } else if (!transactionTime.equals(other.transactionTime))
            return false;
        return true;
    }

}
