package org.l3r8y.process;

public class SleepProcess implements BenchProcess {
    @Override
    public void run() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
