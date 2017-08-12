package com.kun.java8.stream;

import com.google.common.collect.Lists;
import com.kun.java8.entity.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class StreamTester {
    public static void main(String... args) {
        StreamTester tester = new StreamTester();
        // from Stream
        Stream<String> stream = Stream.of("a", "b", "c");

        // from Collection
        List<String> list = Lists.newArrayList();
        stream = list.stream();

        // from Array
        String[] array = new String[]{ "a", "b", "c" };
        stream = Arrays.stream(array);

        IntStream.of(1, 2, 3).forEach(System.out::println);

        // map
        List<Integer> number = Arrays.asList(1, 2, 3);
        List<Integer> squareNumber = number.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squareNumber);

        System.out.println("all to uppercase");
        Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);

        // flatmap
        Stream<List<Integer>> inputStream = Stream.of(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
            flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);

        // peek
        System.out.println("Stream.peek()");
        Stream.of(1, 2, 3, 4, 5)
            .filter(e -> e > 2)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(e -> e * e)
            .peek(e -> System.out.println("Mapped value: " + e))
            .forEach(System.out::println);

        // findFirst
        Optional<Integer> firstEven =
            Stream.of(1, 2, 3, 4, 5)
            .filter(e -> (e % 2 == 0))
            .findFirst();
        if (firstEven.isPresent())
            System.out.println("Found first Even -> " + firstEven.get());

        // reduce
        Integer sum = Stream.of(1, 2, 3, 4)
            .reduce(0, Integer::sum);


        Boolean isAllmatch = Stream.of(2, 4, 8).allMatch(e -> e % 2 == 0);
        System.out.println("Is all match? " + isAllmatch);
        Boolean isAnymatch = Stream.of(1, 4, 5).anyMatch(e -> e % 2 == 0);
        System.out.println("Is any match? " + isAnymatch);
        Boolean isNonematch = Stream.of(2, 4, 8).noneMatch(e -> e % 2 == 0);
        System.out.println("Is none match? " + isNonematch);

        tester.randomNumber();

    }

    public void randomNumber() {
        Random seed = new Random();
        Supplier<Integer> random = seed::nextInt;
        Stream.generate(random).limit(10).forEach(System.out::println);
        IntStream.generate(() -> (int) (System.nanoTime() % 100)).
            limit(10).forEach(System.out::println);
        return;
    }
    public List<String> uniqSort(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            List<String> words = br.lines().
                flatMap(line -> Stream.of(line.split(" "))).
                filter(word -> word.length() > 0).
                map(String::toLowerCase).
                distinct().
                sorted().
                collect(Collectors.toList());
            br.close();
            return words;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
