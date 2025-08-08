package com.sabil.personalitysim;

import java.util.HashMap;
import java.util.Map;

public class Event {

    private String name;
    private float intensity; // 0.0 to 1.0

    // Example: modifier impact on traits (this should later be externalized)
    private Map<String, Float> traitModifiers;

    public Event(String name, float intensity) {
        this.name = name;
        this.intensity = intensity;
        this.traitModifiers = new HashMap<>();

        // Placeholder example for event "Social Conflict"
        if (name.equalsIgnoreCase("Social Conflict")) {
            traitModifiers.put("Fe", -0.6f); // Harmful for Fe
            traitModifiers.put("Fi", -0.2f); // Mildly harmful for Fi
            traitModifiers.put("Te", 0.2f);  // Neutral or slightly stimulating for Te
            traitModifiers.put("E9", -0.7f); // Strong negative for peacemakers
        }

        // Add more event mappings here for testing
    }

    // Evaluate the impact of this event on a person
    public float evaluateImpact(Person person) {
        float impact = 0f;

        for (Map.Entry<String, Float> entry : traitModifiers.entrySet()) {
            String trait = entry.getKey();
            float modifier = entry.getValue();

            float traitValue = trait.startsWith("E")
                ? person.getPersonality().getEnneagramTrait(trait)
                : person.getPersonality().getCognitiveFunction(trait);

            impact += traitValue * modifier;
        }

        // Scale by intensity
        return impact * intensity * 10f; // Scale factor (can be tuned)
    }

    public String getName() {
        return name;
    }

    public float getIntensity() {
        return intensity;
    }

    @Override
    public String toString() {
        return "Event: " + name + " [Intensity: " + intensity + "]";
    }
}
