package com.baeldung.management.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.management.persistence.model.Lead;
import com.baeldung.management.persistence.repo.LeadRepo;

@RestController
@RequestMapping("/leads")
class LeadQueryController {

    @Autowired
    private LeadRepo repo;

    //
    @RequestMapping(method = RequestMethod.GET, value = "/count")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public long count() {
        return repo.count();
    }

    // read - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Lead findById(@PathVariable("id") final Long id) {
        final Lead resourceById = repo.findOne(id);
        return resourceById;
    }

    // read - all

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Lead> findAll() {
        return repo.findAll();
    }

}
