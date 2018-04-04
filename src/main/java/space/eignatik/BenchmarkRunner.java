package space.eignatik;

import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.System.*;
import static org.apache.commons.math3.analysis.FunctionUtils.add;

public class BenchmarkRunner {

    /**
     * Run all benchmarks
     * @param args
     * @throws IOException
     * @throws RunnerException
     */
    public static void main(String[] args) throws IOException, RunnerException {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("1", 100));
        personList.add(new Person("2", 200));
        personList.add(new Person("3", 0));
        personList.add(new Person("4", 500));
        personList.add(new Person("5", 100));

        personList
                .stream()
                .filter((person -> person.getAmount() >= 500))
                .forEach(person -> {
                    person.setAmount(person.getAmount() + 50);
                    out.println(person.getAmount());
                });

    }

    static class Person {
        private String id;
        private int amount;
        Person(String id, int amount) {
            this.id = id;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }
}
