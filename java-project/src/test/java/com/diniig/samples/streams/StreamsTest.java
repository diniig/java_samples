package com.diniig.samples.streams;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamsTest {

    @Test
    void streamTest() {

        IntStream.of(4, 2, 1, 3, 2)
                // .parallel()
                .peek(v -> System.out.println(v + "p "))
                .sorted()
                .map(v -> {
                    System.out.println(v + "m ");
                    return v;
                })
                .flatMap(v -> {
                    System.out.println(v + "fm ");
                    return IntStream.of(v);
                })
                .distinct()
                .forEach(v -> System.out.println(v + "fe "));
        // 1 1 1 1 2 2 2 2 2 2 2 3 3 3 3 4 4 4 4
        // 1 2 2 3 4 1 2 2 3 4 1 2 2 3 4 1 2 3 4 //.parallel()

        // IntStream.of(1, 2, 2, 3, 4)
        // .parallel()
        // .peek(v -> {new Exception(v + "p " +
        // Thread.currentThread().getName()).printStackTrace();})
        // .map(v -> {new Exception(v + "m " +
        // Thread.currentThread().getName()).printStackTrace(); return v;})
        // .flatMap(v -> {new Exception(v + "fm " +
        // Thread.currentThread().getName()).printStackTrace(); return
        // IntStream.of(v);})
        // .distinct()
        // .forEach(v -> new Exception(v + "fe " +
        // Thread.currentThread().getName()).printStackTrace());
    }

    @Test
    void streamSecondUseTest() {
        Stream<String> stream = Stream.of("один", "один", "два", "три");

        stream.forEach(System.out::println);
        stream.forEach(System.out::println); // java.lang.IllegalStateException: stream has already been operated upon
                                             // or closed
    }

    @Test
    void parallelTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);

        stream
                .parallel() // enable
                .peek(v -> System.out.println(v + "p "))
                .peek(v -> System.out.println(v + "pp "))
                .sequential() // disable
                .forEach(v -> System.out.println(v + "fe "));
    }
}
