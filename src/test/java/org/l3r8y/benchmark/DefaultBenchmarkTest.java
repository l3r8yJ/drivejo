package org.l3r8y.benchmark;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l3r8y.process.SleepProcess;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class DefaultBenchmarkTest {
    private DefaultBenchmark benchmark;
    @BeforeEach
    void setUp() {
        this.benchmark = new DefaultBenchmark(
            new SleepProcess()
        );
    }

    @Test
    void throwsExceptionWhenLogWithoutBench() {
        assertThrows(
            IllegalStateException.class,
            () -> {
                this.benchmark.log();
            }
        );
    }

    @Test
    void sleepBenchOn2_5Seconds() {
        assertTimeoutPreemptively(
            Duration.ofMillis(2600),
            () -> {
                this.benchmark.bench();
            }
        ,
            "sleepBenchOn2_5Seconds passed"
        );
        this.benchmark.log();
    }
}