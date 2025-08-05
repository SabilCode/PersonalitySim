package com.sabil.personalitysim;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class PersonalitySim extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture img;
    Environment env = new Environment();

    @Override
    public void create() {
        batch = new SpriteBatch(); // ✅ inisialisasi dulu
        img = new Texture("libgdx.png"); // atau apapun file-nya

        Person p = new Person("Sabil");
        p.act();

        Environment env = new Environment();

    }

    @Override
    public void render () {
        env.update();  // once per frame

        ScreenUtils.clear(0, 0, 0.2f, 1);

        batch.begin();            // ✅ tidak akan error sekarang
        batch.draw(img, 100, 100);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}

