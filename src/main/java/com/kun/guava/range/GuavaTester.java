package com.kun.guava.range;
import com.google.common.base.Optional;
import com.google.common.collect.*;

/**
 * @author zhangku
 * @since 1.0
 */

public class GuavaTester {
    public static void main(String... args) {
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1, 10)); // {[1, 10]}
        rangeSet.add(Range.closedOpen(11, 15)); // disconnected range: {[1, 10], [11, 15)}
        rangeSet.add(Range.closedOpen(15, 20)); // connected range; {[1, 10], [11, 20)}
        rangeSet.add(Range.openClosed(0, 0)); // empty range; {[1, 10], [11, 20)}
        rangeSet.remove(Range.open(5, 10)); // splits [1, 10]; {[1, 5], [10, 10], [11, 20)}

        // view
        System.out.println("view full range set: " + rangeSet);
        System.out.println("view full complement range set: " + rangeSet.complement());
        System.out.println("view each range set:");
        rangeSet.asRanges().forEach(r -> System.out.println(r));

        // query
        if (rangeSet.contains(12))
            System.out.println("range set contains 12");

        Optional<Range<Integer>> range = Optional.fromNullable(rangeSet.rangeContaining(3));
        if (range.isPresent())
            System.out.println("3 is located in range set " + range.get());

        if (rangeSet.encloses(Range.closed(8,16)))
            System.out.println("range set encloses [8, 16]");

        System.out.println("span range set to " + rangeSet.span());

        // rangeMap
        RangeMap<Integer, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(1, 10), "foo"); // {[1, 10] => "foo"}
        rangeMap.put(Range.open(3, 6), "bar"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo"}
        rangeMap.put(Range.open(10, 20), "foo"); // {[1, 3] => "foo", (3, 6) => "bar", [6, 10] => "foo", (10, 20) => "foo"}
        rangeMap.remove(Range.closed(5, 11)); // {[1, 3] => "foo", (3, 5) => "bar", (11, 20) => "foo"}

        System.out.println("Iterate whole range map:");
        rangeMap.asMapOfRanges().entrySet().forEach(it -> System.out.println(it.getKey() + " -> " + it.getValue()));

        RangeMap<Integer, String> rangeMapX = rangeMap.subRangeMap(Range.closed(8, 16));
        System.out.println("view the intersection of rangeMap and rangMapX");
        rangeMapX.asMapOfRanges().entrySet().forEach(it -> System.out.println(it.getKey() + " -> " + it.getValue()));
    }
}
