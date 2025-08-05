package com.sabil.personalitysim;

public class Motivation {
    private Condition condition;
    private float level = 0;

    public Motivation(Condition condition) {
        this.condition = condition;
    }

    public void update() {
        // Contoh logika awal
        level = (1 - condition.hunger) * 0.5f + condition.emotional * 0.5f;
    }

    public float getLevel() {
        return level;
    }
}
