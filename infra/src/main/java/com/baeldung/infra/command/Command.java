package com.baeldung.infra.command;

public abstract class Command {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
