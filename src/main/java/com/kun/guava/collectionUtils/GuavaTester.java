package com.kun.guava.collectionUtils;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.time.DayOfWeek;
import java.util.*;
import java.util.stream.Stream;


/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {
        GuavaTester t = new GuavaTester();

        // static constructor
        List<String> list = Lists.newArrayList();
        List<String> exactly100 = Lists.newArrayListWithCapacity(100);
        List<String> approx100 = Lists.newArrayListWithExpectedSize(100);
        Set<String> approx100Set = Sets.newHashSetWithExpectedSize(100);

        // Guava provided types
        Multiset<String> multiset = HashMultiset.create();
        Multimap<String, Integer> multimap = HashMultimap.create();


        //t.testIterables();
        t.testMapUtils();

    }

    void testIterables() {
        Iterable<Integer> concatenated = Iterables.concat(
                Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        // concatenated has elements 1, 2, 3, 4, 5, 6
        Integer firstElement = concatenated.iterator().next();
        System.out.println(firstElement);
        firstElement = Iterables.getFirst(concatenated,-1);
        System.out.println(firstElement);
        FluentIterable<String> stringFluentIterable
                = FluentIterable.of("I", "am", "not", "a", "student");
        ImmutableSet<String> immutableSet = stringFluentIterable.toSet();

        Stream<String> stringStream = Stream.of("I", "am", "not", "a", "student");


        //String lastAdded = Iterables.getLast(myLinkedHashSet);
        //String theElement = Iterables.getOnlyElement(thisSetIsDefinitelyASingleton);
    }

    void testListUtils() {
        List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
        List<Integer> countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
        List<List<Integer>> parts = Lists.partition(countUp, 2); // {{1, 2}, {3, 4}, {5}}

        return;
    }

    void testSetUtils() {
        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");

        Sets.SetView<String> intersection = Sets.intersection(primes, wordsWithPrimeLength); // contains "two", "three", "seven"
        // I can use intersection as a Set directly, but copying it can be more efficient if I use it a lot.
        Set<String> copy = intersection.immutableCopy();
        System.out.println(copy);

        Set<String> animals = ImmutableSet.of("gerbil", "hamster");
        Set<String> fruits = ImmutableSet.of("apple", "orange", "banana");

        Set<List<String>> product = Sets.cartesianProduct(animals, fruits);
        // {{"gerbil", "apple"}, {"gerbil", "orange"}, {"gerbil", "banana"},
        //  {"hamster", "apple"}, {"hamster", "orange"}, {"hamster", "banana"}}

        Set<Set<String>> animalSets = Sets.powerSet(animals);
        // {{}, {"gerbil"}, {"hamster"}, {"gerbil", "hamster"}}

        return;
    }

    void testMapUtils() {

        Maps.newHashMap();
        Maps.newLinkedHashMap();
        Maps.newEnumMap();



        Iterable<String> strings = Lists.newArrayList("two", "three", "four");
        ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings, new Function<String, Integer>() {
            public Integer apply(String string) {
                return string.length();
            }
        });

        System.out.println(stringsByIndex.toString());

        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
        MapDifference<String, Integer> diff = Maps.difference(left, right);

        diff.entriesInCommon(); // {"b" => 2}
        diff.entriesDiffering(); // {"c" => (3, 4)}
        diff.entriesOnlyOnLeft(); // {"a" => 1}
        diff.entriesOnlyOnRight(); // {"d" => 5}
    }

    void testMultiSetUtils() {
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("a", 2);

        Multiset<String> multiset2 = HashMultiset.create();
        multiset2.add("a", 5);

        multiset1.containsAll(multiset2); // returns true: all unique elements are contained,
        // even though multiset1.count("a") == 2 < multiset2.count("a") == 5
        Multisets.containsOccurrences(multiset1, multiset2); // returns false

        //depreciated?
        //multiset2.removeOccurrences(multiset1); // multiset2 now contains 3 occurrences of "a"

        multiset2.removeAll(multiset1); // removes all occurrences of "a" from multiset2, even though multiset1.count("a") == 2
        multiset2.isEmpty(); // returns true
    }
}
