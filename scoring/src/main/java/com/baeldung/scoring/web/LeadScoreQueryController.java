package com.baeldung.scoring.web;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.scoring.persistence.model.LeadScore;
import com.baeldung.scoring.persistence.repo.LeadScoreRepo;

@RestController
@RequestMapping("/scores")
class LeadScoreQueryController {

    @Autowired
    private LeadScoreRepo repo;

    // read - one

    @RequestMapping(value = "/{leadId}", method = RequestMethod.GET)
    @ResponseBody
    public LeadScore findByLeadId(@PathVariable("leadId") final UUID leadId) {
        final LeadScore resourceById = repo.findOneByLeadId(leadId);
        return resourceById;
    }

    // read - all

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<LeadScore> findAll() {
        return repo.findAll();
    }

}
