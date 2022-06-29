package io.conferencr.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class MockVotingServiceTest {

    @Inject
    MockVotingService mockerService;

    @Test
    public void testStartingMocker() {

        mockerService.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            assertNull(e);
        }
        assertTrue(mockerService.isRunning());
    }

    @Test
    public void testStoppingMocker() {

        mockerService.stop();
        assertFalse(mockerService.isRunning());
    }
}
