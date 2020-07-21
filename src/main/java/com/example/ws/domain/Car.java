package com.example.ws.domain;

public class Car implements Comparable<Car> {

    private String name;
    private Integer userYear;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserYear() {
        return userYear;
    }

    public void setUserYear(Integer userYear) {
        this.userYear = userYear;
    }

    public Car() {

    }

    public Car(String name, Integer userYear) {
        this.name = name;
        this.userYear = userYear;
    }

    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", userYear=" + userYear +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.getUserYear().compareTo(o.getUserYear());
    }

}
