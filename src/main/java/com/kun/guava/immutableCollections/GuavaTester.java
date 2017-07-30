package com.kun.guava.immutableCollections;

import com.google.common.collect.ImmutableSet;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {

    public static void main(String... args) {

        // construct with ImmutableSet.of()
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
            "red",
            "orange",
            "yellow",
            "green",
            "blue",
            "purple");

        // construct with ImmutableSet.copyOf
        Set<String> s1 = new HashSet<String>();
        s1.add("x");
        s1.add("y");
        s1.add("z");

        ImmutableSet<String> ALPHA = ImmutableSet.copyOf(s1);

        // construct with ImmutableSet.builder()
        ImmutableSet<String> NEW = ImmutableSet.<String>builder()
            .add("a")
            .add("z")
            .addAll(s1)
            .build();

        // asList()
        System.out.println(NEW.asList());
    }
}
