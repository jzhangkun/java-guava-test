package com.kun.java8.entity;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author: jzhangkun
 * @since: 1.0
 */
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person(String firstName, String lastName, Integer age) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.age       = age;
    }

    public String getFirstName() { return this.firstName; }
    public String getLastName() { return this.lastName; }
    public Integer getAge() { return this.age; }

    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("name", this.firstName + " " + this.lastName)
            .add("age", this.age)
            .toString();
    }

    public static List<Person> createGroupPerson() {
        List<Person> person = Lists.newArrayList();
        person.add(new Person("San", "Zhang", 15));
        person.add(new Person("Si", "Li", 20));
        person.add(new Person("Wu", "Wang", 29));
        person.add(new Person("Liu", "Zhao", 15));
        return person;
    }
}
