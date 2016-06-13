package com.baeldung.write.test;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.baeldung.write.commands.CreateLead;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommandUnitTest {

    // tests

    @Test
    public final void whenCommandIsSerialized_thenCorrect() throws JsonProcessingException {
        new ObjectMapper().writeValueAsString(new CreateLead(randomAlphabetic(6)));
    }

    @Test
    public final void whenCommandIsDeserialized_thenCorrect() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        final CreateLead originalCommand = new CreateLead(randomAlphabetic(6));
        final String commandAsString = objectMapper.writeValueAsString(originalCommand);
        final CreateLead command = objectMapper.readValue(commandAsString, CreateLead.class);

        assertThat(command, equalTo(originalCommand));
    }

}
