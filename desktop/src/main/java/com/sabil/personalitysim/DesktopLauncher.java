package com.sabil.personalitysim;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class DesktopLauncher {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("PersonalitySim");
        config.setWindowedMode(640, 480); // Not used now
        config.setForegroundFPS(60);
        new Lwjgl3Application(new PersonalitySim(), config);
    }
}
