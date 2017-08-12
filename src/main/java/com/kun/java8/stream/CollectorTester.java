package com.kun.java8.stream;

import com.kun.java8.entity.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class CollectorTester {
    public static void main(String... args) {
        List<Person> person = Person.createGroupPerson();

        // groupingBy
        Map<Integer, List<Person>> personGroups = person.stream()
            .collect(Collectors.groupingBy(Person::getAge));

        personGroups.entrySet()
            .forEach(e -> System.out.println("Age " + e.getKey() + " = " + e.getValue().size()));

        // partitioningBy

        Map<Boolean, List<Person>> children = person.stream()
            .collect(Collectors.partitioningBy(p -> p.getAge() < 18));


        System.out.println("Children size: " + children.get(true).size());
        System.out.println("Audit size: " + children.get(false).size());

        Map<Integer, List<Person>> ageGroup = person.stream()
            .collect(Collectors.groupingBy(p -> p.getAge() / 5));

        ageGroup.entrySet()
            .forEach(e -> System.out.println("Age Group " + e.getKey() + " = " + e.getValue().size()));
    }
}
