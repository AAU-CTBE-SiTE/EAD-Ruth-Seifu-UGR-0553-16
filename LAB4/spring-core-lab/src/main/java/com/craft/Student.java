package com.craft;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;
    private List<Subject> subjects;

    public Student(@Value("101") int id,
                   @Value("John Doe") String name,
                   @Value("20") int age,
                   Address address,
                   List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student Name: " + this.getName());

        int index = 1;
        for (Subject subject : subjects) {
            System.out.println("Subject " + index + ": " + subject.getSubjectName());
            index++;
        }
    }

    @Override
    public String toString() {
        return "Student(id=" + id
                + ", name=" + name
                + ", age=" + age
                + ", address=" + address
                + ", subjects=" + subjects
                + ")";
    }
}
