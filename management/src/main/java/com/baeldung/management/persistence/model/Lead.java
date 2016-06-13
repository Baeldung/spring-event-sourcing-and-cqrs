package com.baeldung.management.persistence.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID leadId;

    private String name;

    public Lead() {
        super();
    }

    public Lead(final UUID leadId, final String name) {
        super();

        this.leadId = leadId;
        this.name = name;
    }

    //

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(final UUID leadId) {
        this.leadId = leadId;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((leadId == null) ? 0 : leadId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        final Lead other = (Lead) obj;
        if (leadId == null) {
            if (other.leadId != null)
                return false;
        } else if (!leadId.equals(other.leadId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
