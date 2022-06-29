package io.conferencr.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
public class MockerServiceTest {

    @Inject
    MockerService mockerService;

    @Test
    public void testStartingMocker() {

        mockerService.start();
        assertTrue(mockerService.isRunning());
    }
}
