package com.baeldung.scoring.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.baeldung.scoring.persistence.model.LeadScore;
import com.baeldung.scoring.persistence.repo.LeadScoreRepo;
import com.baeldung.store.events.LeadClickedOnPromotionalLink;
import com.baeldung.store.events.LeadCreated;

@Service
public class ScoringProjection {

    @Autowired
    private LeadScoreRepo leadScoreRepo;

    //

    @EventListener
    public void onLeadCreatedCalculateScore(final LeadCreated event) {
        final int initialScore = calculateInitialScoreOfLead(event);
        leadScoreRepo.save(new LeadScore(event.getLeadId(), initialScore));
    }

    @EventListener
    public void onLeadClickedOnPromotionalLinkReCalculateScore(final LeadClickedOnPromotionalLink event) {
        final LeadScore existingScore = leadScoreRepo.findOneByLeadId(event.getIdOfLead());
        final int newScore = recalculateScoreOfLead(event, existingScore.getScore());
        existingScore.setScore(newScore);

        leadScoreRepo.save(existingScore);
    }

    //

    private final int calculateInitialScoreOfLead(final LeadCreated event) {
        return 10;
    }

    private final int recalculateScoreOfLead(final LeadClickedOnPromotionalLink event, final int oldScore) {
        return oldScore + 1;
    }

}
