package com.baeldung.management.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.baeldung.management.persistence.model.Lead;
import com.baeldung.management.persistence.repo.LeadRepo;
import com.baeldung.store.events.LeadCreated;

@Service
public class ManagementProjection {

    @Autowired
    private LeadRepo leadRepo;

    @EventListener
    public void onLeadCreated(final LeadCreated event) {
        leadRepo.save(new Lead(event.getLeadId(), event.getName()));
    }

}
