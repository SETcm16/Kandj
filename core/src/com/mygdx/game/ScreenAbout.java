package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    KiSH ki;
    Texture imgAbout;
    TextButton btnBack;

    String textAbout = "Игра\n" +
            "была";

    public ScreenAbout(KiSH kiSH) {
        ki = kiSH;
        imgAbout = new Texture("foni/");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // касания экрана/клики мышью
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if(btnBack.hit(ki.touch.x, ki.touch.y)){
                ki.setScreen(ki.screenMenu);
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgAbout, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        //ki.font.draw(ki.batch, textAbout, 50, 650);
        btnBack.font.draw(ki.batch, btnBack.text, btnBack.x, btnBack.y);
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
        imgAbout.dispose();
    }
}
