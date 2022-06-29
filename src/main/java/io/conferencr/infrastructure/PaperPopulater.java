package io.conferencr.infrastructure;

import com.github.javafaker.Faker;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class PaperPopulater {

    private static final Logger LOGGER = getLogger(PaperPopulater.class);

    Faker faker = new Faker();

    Collection<String> reviewerCollection;

    public void populateReviewers() {

        reviewerCollection = Stream.generate(this::fakeEmail)
                .limit(10)
                .collect(Collectors.toList());
    }

    protected Collection<String> getReviewerCollection() {
        return reviewerCollection;
    }

    private String fakeEmail() {
        return faker.internet().emailAddress();
    }

}
