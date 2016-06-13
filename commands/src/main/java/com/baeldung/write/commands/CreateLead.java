package com.baeldung.write.commands;

import javax.validation.constraints.NotNull;

import com.baeldung.infra.command.Command;

public class CreateLead extends Command {

    @NotNull
    private String name;

    public CreateLead() {
        super();
    }

    public CreateLead(final String name) {
        super();

        this.name = name;
    }

    //

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    //

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        final CreateLead other = (CreateLead) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}
