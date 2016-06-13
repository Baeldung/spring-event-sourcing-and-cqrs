package com.baeldung.management.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baeldung.management.persistence.model.Lead;

public interface LeadRepo extends JpaRepository<Lead, Long> {

    Lead findOneByName(final String name);

}
