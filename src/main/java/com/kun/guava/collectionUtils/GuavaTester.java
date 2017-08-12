package com.kun.guava.collectionUtils;

import com.google.common.base.CharMatcher;
import com.google.common.collect.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {

        // static constructor
        List<String> list = Lists.newArrayList();
        List<String> exactly100 = Lists.newArrayListWithCapacity(100);
        List<String> approx100 = Lists.newArrayListWithExpectedSize(100);
        Set<String> approx100Set = Sets.newHashSetWithExpectedSize(100);

        // Guava provided types
        Multiset<String> multiset = HashMultiset.create();
        Multimap<String, Integer> multimap = HashMultimap.create();

    }
}
