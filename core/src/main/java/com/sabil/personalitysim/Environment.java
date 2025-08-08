package com.sabil.personalitysim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environment {

    private List<Event> currentEvents;

    public Environment() {
        this.currentEvents = new ArrayList<>();
    }

    // Called every tick to create a new event
    public void generateRandomEvent() {
        String[] eventTemplates = {
            "Social Conflict", "Economic Boom", "Natural Disaster",
            "Cultural Festival", "Technology Advancement", "Political Scandal"
        };

        Random rand = new Random();
        String name = eventTemplates[rand.nextInt(eventTemplates.length)];
        float intensity = 0.3f + rand.nextFloat() * 0.7f; // intensity 0.3 - 1.0

        Event newEvent = new Event(name, intensity);
        currentEvents.clear(); // Only one active event for simplicity
        currentEvents.add(newEvent);

        System.out.println("New Event Generated: " + newEvent);
    }


    public List<Event> getCurrentEvents() {
        return currentEvents;
    }
}
