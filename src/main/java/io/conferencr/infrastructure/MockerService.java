package io.conferencr.infrastructure;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MockerService {

    private boolean running;

    public void start() {

        running = true;
    }

    protected void start(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

}
