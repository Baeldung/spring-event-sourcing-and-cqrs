package com.baeldung.write.web;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.store.events.LeadClickedOnPromotionalLink;
import com.baeldung.store.events.LeadCreated;
import com.baeldung.store.service.EventStore;
import com.baeldung.write.commands.CreateLead;
import com.baeldung.write.commands.LeadClickOnPromotionalLink;

@RestController
@RequestMapping("/commands")
class CommandController {

    @Autowired
    private EventStore eventStore;

    //

    @RequestMapping(value = "/leads", method = RequestMethod.POST)
    public void crateLead(final @Valid @RequestBody CreateLead createLeadCommand) {
        final LeadCreated event = new LeadCreated(UUID.randomUUID(), UUID.randomUUID(), createLeadCommand.getName());

        eventStore.save(event);
    }

    @RequestMapping(value = "/leads/activity", method = RequestMethod.POST)
    public void leadClickOnPromotionalLink(final @Valid @RequestBody LeadClickOnPromotionalLink leadClickOnPromotionalLinkCommand) {
        final UUID correllationId = UUID.randomUUID();

        final LeadClickedOnPromotionalLink event = new LeadClickedOnPromotionalLink(leadClickOnPromotionalLinkCommand.getIdOfLead());
        event.setCorrelationId(correllationId);

        eventStore.save(event);
    }

}
