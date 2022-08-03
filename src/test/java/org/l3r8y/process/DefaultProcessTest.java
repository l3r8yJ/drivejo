package org.l3r8y.process;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class DefaultProcessTest {

    private DefaultProcess process;

    @BeforeEach
    void setUp() {
        process = new DefaultProcess(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void run() {
        assertTimeoutPreemptively(
            Duration.ofMillis(1100),
            () -> {
                this.process.run();
            }
        );
    }
}