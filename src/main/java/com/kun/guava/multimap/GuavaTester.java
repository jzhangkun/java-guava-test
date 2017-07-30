package com.kun.guava.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.Set;


/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {
        ListMultimap<String, Integer> map = ArrayListMultimap.create();
        map.put("a", 1);
        map.put("a", 2);
        map.put("b", 2);
        map.put("c", 3);

        System.out.println("Output the whole map");
        System.out.println(map);

        Collection<Integer> aa = map.get("a");
        System.out.println("Get Collection element of a");
        System.out.println(aa);

        System.out.println("Get all values");
        for (Integer x: map.values())
            System.out.println(x);

        Set<String> keys = map.keySet();
        System.out.println("Get all keys");
        System.out.println(keys);

        // interators
        map.asMap().entrySet().forEach(it -> System.out.println(it.getKey() + "=" + it.getValue()) );
    }
}
