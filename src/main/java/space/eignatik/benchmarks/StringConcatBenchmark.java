package space.eignatik.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StringConcatBenchmark {

    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MINUTES)
    @Fork(value = 1, warmups = 1) @Warmup(iterations = 1)
    public String simpleConcatenation() {
        return "foo" + "bar";
    }

    @Benchmark @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MINUTES)
    @Fork(value = 1, warmups = 1) @Warmup(iterations = 1)
    public String usingStringBuilder() {
        return new StringBuilder()
                .append("foo")
                .append("bar")
                .toString();
    }

    @Benchmark @BenchmarkMode(Mode.Throughput) @OutputTimeUnit(TimeUnit.MINUTES)
    @Fork(value = 1, warmups = 1) @Warmup(iterations = 1)
    public String usingStringFormat() {
        return String.format("%s%s", "foo", "bar");
    }
}
