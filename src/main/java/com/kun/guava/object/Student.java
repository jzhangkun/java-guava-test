package com.kun.guava.object;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @author: jzhangkun
 * @since: 1.0
 */

public class Student {
    private String firstName;
    private String lastName;
    private int rollNo;
    private String className;

    public Student(String firstName, String lastName, int rollNo, String className) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNo = rollNo;
        this.className = className;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student) || object == null) {
            return false;
        }
        Student student = (Student) object;
        // no need to handle null here
        // Objects.equal("test", "test") == true
        // Objects.equal("test", null) == false
        // Objects.equal(null, "test") == false
        // Objects.equal(null, null) == true
        return Objects.equal(firstName, student.firstName) // first name can be null
            && Objects.equal(lastName, student.lastName) // last name can be null
            && Objects.equal(rollNo, student.rollNo)
            && Objects.equal(className, student.className);// class name can be null
    }

    @Override
    public int hashCode() {
        //no need to compute hashCode by self
        return Objects.hashCode(className, rollNo);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("Name", this.getFirstName() + " " + this.getLastName())
            .add("Class", this.getClassName())
            .add("Roll No", this.getRollNo())
            .toString();
    }
}
