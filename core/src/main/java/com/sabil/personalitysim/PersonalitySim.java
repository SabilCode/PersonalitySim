package com.sabil.personalitysim;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

import java.util.LinkedList;
import java.util.List;

public class PersonalitySim extends ApplicationAdapter {

    private SpriteBatch batch;
    private BitmapFont font;

    private Environment environment;
    private List<Person> people;

    private float timeAccumulator = 0f;
    private final float TICK_INTERVAL = 1f; // 1 second per simulation tick

    private List<String> eventLog = new LinkedList<>(); // showing last log
    private final int MAX_LOG_LINES = 15;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();

        environment = new Environment();
        people = new ArrayList<>();

        // Initialize 8 sample persons
        for (int i = 0; i < 8; i++) {
            people.add(new Person("Person_" + (i + 1)));
        }

        Gdx.app.log("System", "Simulation started with 8 Persons.");
    }

    @Override
    public void render() {
        // Clear screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Update simulation at fixed interval
        float delta = Gdx.graphics.getDeltaTime();
        timeAccumulator += delta;

        while (timeAccumulator >= TICK_INTERVAL) {
            updateSimulation();
            timeAccumulator -= TICK_INTERVAL;
        }

        batch.begin();

        float lineSpacing = 20f;
        // Showing Person, Trait, Happiness
        float y = Gdx.graphics.getHeight() - 40;
        for (Person p : people) {
            String line = String.format("%s | %s | : %.2f%%",
                p.getName(),
                p.getPersonality().toString(),
                p.getHappiness()
            );
            font.draw(batch, line, 20, y);
            y -= lineSpacing;
        }
        // Showing event log
        float logY = Gdx.graphics.getHeight() - 20;
        for (int i = 0; i < eventLog.size(); i++) {
            font.draw(batch, eventLog.get(i), 1300, logY);
            logY -= lineSpacing;
        }

        batch.end();
    }

    private void updateSimulation() {
        environment.generateRandomEvent();
        Event current = environment.getCurrentEvents().get(0);

        eventLog.clear();
        eventLog.add("[Event] " + current.getName() + " (Intens: " + String.format("%.2f", current.getIntensity()) + ")");

        for (Person p : people) {
            float impact = current.evaluateImpact(p);
            p.adjustHappiness(impact);  // 🔧 FIXED LINE

            String impactStr = String.format("%+.2f", impact);
            eventLog.add(p.getName() + " affected: " + impactStr);
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
