package io.conferencr.infrastructure;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static org.slf4j.LoggerFactory.getLogger;

@ApplicationScoped
public class MockVotingService {

    private static final Logger LOGGER = getLogger(MockVotingService.class);

    private boolean running;

    protected CompletableFuture<Void> start() {
        LOGGER.info("CFP Mocker now starting");
        this.running = true;
        return CompletableFuture.runAsync(mockVoting);
    }

    Runnable mockVoting = () -> {
        while (running) {
            if(!running) LOGGER.info("CFP Mocker now stopping");
            try {
                Thread.sleep((new Random().nextInt(3 - 1) + 1) * 1000);
                LOGGER.info("still running");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public void stop() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

}
