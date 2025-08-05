package com.sabil.personalitysim;

public class Environment {
    Person p1 = new Person("Sabil");
    Person p2 = new Person("Ayu");

    public void update() {
        p1.act();
        p2.act();

        if (p1.happiness >= 100) {
            System.out.println(p1.name + " wins!");
        } else if (p2.happiness >= 100) {
            System.out.println(p2.name + " wins!");
        }
    }
}
