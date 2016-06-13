package com.baeldung;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.baeldung.store.test.EventStoreIntegrationTest;
import com.baeldung.write.test.CommandIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CommandIntegrationTest.class, EventStoreIntegrationTest.class })
public class CommandIntegrationSuite {
    //
}