package com.baeldung.store.events;

import java.util.UUID;

import com.baeldung.infra.event.BaseEvent;

public class LeadClickedOnPromotionalLink extends BaseEvent {

    private UUID idOfLead;

    public LeadClickedOnPromotionalLink() {
        super();
    }

    public LeadClickedOnPromotionalLink(final UUID idOfLead) {
        this.idOfLead = idOfLead;
    }

    //

    public UUID getIdOfLead() {
        return idOfLead;
    }

    public void setIdOfLead(final UUID idOfLead) {
        this.idOfLead = idOfLead;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOfLead == null) ? 0 : idOfLead.hashCode());
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
        final LeadClickedOnPromotionalLink other = (LeadClickedOnPromotionalLink) obj;
        if (idOfLead == null) {
            if (other.idOfLead != null)
                return false;
        } else if (!idOfLead.equals(other.idOfLead))
            return false;
        return true;
    }

}
