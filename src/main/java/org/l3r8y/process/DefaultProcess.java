package org.l3r8y.process;

import java.util.Objects;

/**
 * Default process to bench.
 */
public class DefaultProcess implements BenchProcess {

    /**
     * The exec.
     */
    private final Runnable exec;

    /**
     * Ctor.
     *
     * @param exec Runnable that will execute.
     */
    public DefaultProcess(Runnable exec) {
        if (Objects.equals(null, exec)) {
            throw new IllegalArgumentException("Runnable mustn't be null");
        }
        this.exec = exec;
    }

    @Override
    public void run() {
        this.exec.run();
    }
}
