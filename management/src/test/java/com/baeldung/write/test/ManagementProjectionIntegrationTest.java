package com.baeldung.write.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baeldung.management.spring.ManagementProjectionApp;
import com.baeldung.management.spring.ManagementProjectionPersistenceConfig;
import com.baeldung.store.spring.EventStorePersistenceConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ManagementProjectionApp.class, ManagementProjectionPersistenceConfig.class, EventStorePersistenceConfig.class })
public class ManagementProjectionIntegrationTest {

    // tests

    @Test
    public final void whenContextIsBootstrapped_thenCorrect() {
        //
    }

}
