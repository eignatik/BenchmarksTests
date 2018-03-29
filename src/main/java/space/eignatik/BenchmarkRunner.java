package space.eignatik;

import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;

public class BenchmarkRunner {

    /**
     * Run all benchmarks
     * @param args
     * @throws IOException
     * @throws RunnerException
     */
    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }
}
