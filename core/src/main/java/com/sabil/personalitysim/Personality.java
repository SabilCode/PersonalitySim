package com.sabil.personalitysim;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Personality {

    // Cognitive Function traits (e.g. Ne, Ni, Se, etc.)
    private Map<String, Float> cognitiveFunctions;

    // Enneagram traits (E1 - E9)
    private Map<String, Float> enneagramTraits;

    private static final String[] CF_KEYS = {
        "Ne", "Ni", "Se", "Si", "Te", "Ti", "Fe", "Fi"
    };

    private static final String[] ENNEAGRAM_KEYS = {
        "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9"
    };

    public Personality() {
        this.cognitiveFunctions = generateRandomTraits(CF_KEYS);
        this.enneagramTraits = generateRandomTraits(ENNEAGRAM_KEYS);
    }

    // Generate random traits with float values between 0.0 and 1.0
    private Map<String, Float> generateRandomTraits(String[] keys) {
        Random rand = new Random();
        Map<String, Float> traits = new HashMap<>();
        for (String key : keys) {
            traits.put(key, rand.nextFloat());
        }
        return traits;
    }

    public float getCognitiveFunction(String cf) {
        return cognitiveFunctions.getOrDefault(cf, 0f);
    }

    public float getEnneagramTrait(String e) {
        return enneagramTraits.getOrDefault(e, 0f);
    }

    public Map<String, Float> getAllCognitiveFunctions() {
        return cognitiveFunctions;
    }

    public Map<String, Float> getAllEnneagramTraits() {
        return enneagramTraits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // CF section
        sb.append("CF[");
        int count = 0;
        for (String key : CF_KEYS) {
            float value = cognitiveFunctions.getOrDefault(key, 0f);
            sb.append(key).append(": ").append(String.format("%.2f", value));
            if (++count < CF_KEYS.length) sb.append(", ");
        }
        sb.append("] ");

        // Enneagram section
        sb.append("Ennea[");
        count = 0;
        for (String key : ENNEAGRAM_KEYS) {
            float value = enneagramTraits.getOrDefault(key, 0f);
            sb.append(key).append(": ").append(String.format("%.2f", value));
            if (++count < ENNEAGRAM_KEYS.length) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }
}
