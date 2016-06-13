package com.baeldung.scoring.persistence.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baeldung.scoring.persistence.model.LeadScore;

public interface LeadScoreRepo extends JpaRepository<LeadScore, Long> {

    LeadScore findOneByLeadId(final UUID leadId);

}
