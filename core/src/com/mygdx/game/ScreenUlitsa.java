package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenUlitsa implements Screen {
    KiSH ki;

    Texture imgUlitsa;
    Texture imgBrod;

    public ScreenUlitsa(KiSH kiSH) {
        ki = kiSH;
        imgUlitsa = new Texture("foni/ulitsa1.jpg");
        imgBrod = new Texture("geroi/brodyaga.png");
    }

    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);

        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgUlitsa, 0,0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(imgBrod, 20, 200, 150, 300);
        ki.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        imgUlitsa.dispose();
    }
}
