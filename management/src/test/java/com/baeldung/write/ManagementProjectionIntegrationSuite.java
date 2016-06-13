package com.baeldung.write;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.baeldung.write.test.EventStoreInProjectionIntegrationTest;
import com.baeldung.write.test.ManagementProjectionIntegrationTest;
import com.baeldung.write.test.SudoManagementProjectionIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ManagementProjectionIntegrationTest.class, SudoManagementProjectionIntegrationTest.class, EventStoreInProjectionIntegrationTest.class })
public class ManagementProjectionIntegrationSuite {
    //
}