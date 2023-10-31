package org.java15.models;

import org.java15.enums.Gender;
import org.java15.enums.Status;

public class Person {
    private String name;
    private Gender gender;
    private int age;
    private Status status;

    public Person(String name, Gender gender, int age, Status status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Status getStatus() {
        return status;
    }
}
