package com.kun.java8.lambda;

import com.google.common.collect.Lists;
import com.kun.java8.entity.Person;

import java.util.List;
import static java.util.Comparator.comparing;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class CompartorTester {
    public static void main(String... args) {
        Person p1 = new Person("John", "Snow", 28);
        Person p2 = new Person("Mike", "Stone", 35);
        Person p3 = new Person("Hugo", "Peter", 28);

        List<Person> person = Lists.newArrayList();
        person.add(p1);
        person.add(p2);
        person.add(p3);

        System.out.println("Before the sort");
        person.forEach(System.out::println);

        // sort by age reverse order
        person.sort(comparing(Person::getAge).reversed());
        System.out.println("After the sort");
        person.forEach(System.out::println);

        // sort by age first and then by last name
        person.sort(comparing(Person::getAge).thenComparing(Person::getLastName));
        System.out.println("After the sort again");
        person.forEach(System.out::println);

    }
}
