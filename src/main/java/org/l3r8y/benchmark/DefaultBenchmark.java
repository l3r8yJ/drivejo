package org.l3r8y.benchmark;

import com.jcabi.log.Logger;
import org.cactoos.text.FormattedText;
import org.l3r8y.process.BenchProcess;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

/**
 * The type Default benchmark.
 */
public class DefaultBenchmark implements Benchmark {
    private long time = -1;
    /**
     * The Process.
     */
    private final BenchProcess process;

    /**
     * Instantiates a new Default benchmark.
     *
     * @param process the process
     */
    public DefaultBenchmark(final BenchProcess process) {
        if (Objects.equals(null, process)) {
            throw new IllegalArgumentException("Process cannot be a null!");
        }
        this.process = process;
    }

    @Override
    public void log() {
        if (-1 == this.time) {
            throw new IllegalStateException("Cannot create log before benchmark execution!");
        }
        try {
            Logger.info(
                this,
                new FormattedText(
                    "%s process finished for %d seconds.",
                    this.getClass().getName(),
                    this.time
                ).asString()
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(this.time);
    }

    @Override
    public void bench() {
        final Instant start = Instant.now();
        this.process.run();
        final Instant end = Instant.now();
        this.time = Duration.between(start, end).toSeconds();
    }
}
