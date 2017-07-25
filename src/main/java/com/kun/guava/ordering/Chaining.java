package com.kun.guava.ordering;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;
import com.kun.guava.object.Student;
import com.google.common.base.Function;


/**
 * @author: jzhangkun
 * @since: 1.0
 */

public class Chaining {
    public static void main(String... args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("sam", "sha", 5, "D"));
        students.add(new Student("zac", "shi", 2, "A"));
        students.add(new Student("rain", "feng", 6, "B"));
        students.add(new Student("cc", "dd", 1, "C"));

        // chaining the Ordering
        Ordering<Student> ordering = Ordering.natural().onResultOf(new Function<Student, Integer>() {
            public Integer apply(Student s) {
                return s.getRollNo();
            }
        });
        System.out.println("Input list: ");
        students.forEach(s -> { System.out.println(s); });
        Collections.sort(students, ordering);
        System.out.println("Sorted: ");
        students.forEach(s -> { System.out.println(s); });

        // extending abstract Ordering class directly
        Ordering<Student> byClassNameOrdering = new Ordering<Student>() {
            public int compare(Student left, Student right) {
                return left.getClassName().compareTo(right.getClassName());
            }
        };

        Collections.sort(students, byClassNameOrdering);
        System.out.println("Sorted by className: ");
        students.forEach(s -> { System.out.println(s); });
    }
}
