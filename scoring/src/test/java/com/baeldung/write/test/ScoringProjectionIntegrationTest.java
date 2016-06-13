package com.baeldung.write.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.scoring.spring.ScoringProjectionApp;
import com.baeldung.scoring.spring.ScoringProjectionPersistenceConfig;
import com.baeldung.store.spring.EventStorePersistenceConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ScoringProjectionApp.class, ScoringProjectionPersistenceConfig.class, EventStorePersistenceConfig.class })
public class ScoringProjectionIntegrationTest {

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenCorrect() {
        //
    }

}
