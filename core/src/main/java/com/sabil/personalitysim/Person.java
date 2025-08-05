package com.sabil.personalitysim;

public class Person {
    String name;
    float happiness = 50;

    public Person(String name) {
        this.name = name;

    }

    public void act() {
        // For now, add fixed happiness each turn
        happiness += 1.5f;
        System.out.println(name + " acts → happiness: " + happiness);
    }
}
