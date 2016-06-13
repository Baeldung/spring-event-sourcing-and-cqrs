package com.baeldung.scoring.persistence.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LeadScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID leadId;

    private Integer score;

    public LeadScore() {
        super();
    }

    public LeadScore(final UUID leadId, final Integer score) {
        super();

        this.leadId = leadId;
        this.score = score;
    }

    //

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public UUID getLeadId() {
        return leadId;
    }

    public void setLeadId(final UUID leadId) {
        this.leadId = leadId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((leadId == null) ? 0 : leadId.hashCode());
        result = prime * result + ((score == null) ? 0 : score.hashCode());
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
        final LeadScore other = (LeadScore) obj;
        if (leadId == null) {
            if (other.leadId != null)
                return false;
        } else if (!leadId.equals(other.leadId))
            return false;
        if (score == null) {
            if (other.score != null)
                return false;
        } else if (!score.equals(other.score))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LeadScore [leadId=" + leadId + ", score=" + score + "]";
    }

}
