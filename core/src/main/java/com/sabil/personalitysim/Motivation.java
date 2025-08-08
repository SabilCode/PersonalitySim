package com.sabil.personalitysim;

import java.util.Random;

public class Motivation {

    public enum Type {
        FAME, WEALTH, KNOWLEDGE, LOVE, HARMONY, POWER
    }

    private Type primary;

    public Motivation(Type primary) {
        this.primary = primary;
    }

    public static Motivation generateRandom() {
        Type[] values = Type.values();
        Type randomType = values[new Random().nextInt(values.length)];
        return new Motivation(randomType);
    }

    public Type getPrimary() {
        return primary;
    }

    @Override
    public String toString() {
        return "Motivated by: " + primary.name();
    }
}
