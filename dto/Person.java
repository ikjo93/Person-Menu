package collections.dto;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 440050353130360396L;
    private int index;
    private String name;
    private int age;
    private String job;

    public Person() {
    }

    public Person(int index, String name, int age, String job) {
        this.index = index;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    /* getter & setter */

    public boolean hasSameIndex(int index) {
        return this.index == index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
