package com.kun.guava.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {
        BiMap<String, Integer> userId = HashBiMap.create();
        userId.put("a", 1);
        userId.put("b", 2);
        userId.put("c", 3);

        System.out.println("id of a: " + userId.get("a"));
        System.out.println("who is under id 3: " + userId.inverse().get(3) );

        BiMap<String, String> pair = HashBiMap.create();
        try {
            pair.put("a", "b");
            pair.put("c", "d");
            pair.put("e", "b");
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("using force put");
            pair.forcePut("e", "b");
        }

        if (!pair.containsKey("a"))
            System.out.println("key a is missing");
        if (pair.containsKey("e"))
            System.out.println("key e was added, value is " + pair.get("c"));
    }
}
