package space.eignatik.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class StreamAPIBenchmarks {
    public static void main(String[] args) throws IOException, RunnerException {
        org.openjdk.jmh.Main.main(args);
    }

    private static String[] elems = {"foo", "bar", "cat", "lol", "java", "c++", "vasya", "dog", "man", "girl", "lorem", "ipsum", "dolor", "amel"};
    private static List<Integer> list1;

    @Setup
    public static void setUp() {
        list1 = new ArrayList<>();
        for (int i = 0; i < 1000; i ++) {
            list1.add(new Random().nextInt());
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    public void printArrayOld() {
        List<String> list = Arrays.asList(elems);
        for (String elem : list) {
            elem.toUpperCase();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    public void printArrayWithStreams() {
        Arrays.asList(elems).forEach(String::toUpperCase);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    public void applyArrayOld() {
        List<Integer> list = new ArrayList<>(list1);
        for (Integer elem : list) {
            elem.doubleValue();
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Fork(value = 2)
    public void applyArrayWithStreams() {
        new ArrayList<>(list1).forEach(Integer::byteValue);
    }


}
