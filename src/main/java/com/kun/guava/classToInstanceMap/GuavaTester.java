package com.kun.guava.classToInstanceMap;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class GuavaTester {
    public static void main(String... args) {
        ClassToInstanceMap<Integer> numberDefaults = MutableClassToInstanceMap.create();
        numberDefaults.putInstance(Integer.class, Integer.valueOf(0));

        System.out.println(numberDefaults);
        System.out.println(numberDefaults.getInstance(Integer.class));
    }
}
