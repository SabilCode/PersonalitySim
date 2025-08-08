package com.sabil.personalitysim;

public class Person {

    private String name;
    private float happiness; // 0 - 100
    private Personality personality;

    public Person(String name) {
        this.name = name;
        this.happiness = 50.0f; // Starting midpoint
        this.personality = new Personality(); // New structure
    }

    public String getName() {
        return name;
    }

    public float getHappiness() {
        return happiness;
    }

    public void adjustHappiness(float value) {
        happiness = Math.max(0, Math.min(100, happiness + value));
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality p) {
        this.personality = p;
    }
}
