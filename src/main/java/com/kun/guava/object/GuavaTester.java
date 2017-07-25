package com.kun.guava.object;

/**
 * @author: jzhangkun
 * @since: 1.0
 */

public class GuavaTester {
    public static void main(String args[]) {
        Student s1 = new Student("Mahesh", "Parashar", 1, "VI");
        Student s2 = new Student("Suresh", null, 3, null);

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s1);
    }
}

