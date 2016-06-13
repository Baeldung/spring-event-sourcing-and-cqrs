package com.baeldung.write;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.baeldung.write.test.ScoringProjectionIntegrationTest;
import com.baeldung.write.test.SudoCommunicationProjectionIntegrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ScoringProjectionIntegrationTest.class, SudoCommunicationProjectionIntegrationTest.class })
public class ScoringProjectionIntegrationSuite {
    //
}