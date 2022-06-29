package io.conferencr.infrastructure;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class PopulaterTest {

    @Inject
    PaperPopulater paperPopulater;

    @Test
    public void testPopulate() {

        paperPopulater.populateReviewers();
        assertEquals(10, paperPopulater.getReviewerCollection().size());
    }
}
