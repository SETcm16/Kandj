package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenUlitsa implements Screen {
    KiSH ki;

    Texture imgUlitsa;

    public ScreenUlitsa(KiSH kiSH) {
        imgUlitsa = new Texture("foni/ulitsa.jpg");


    }
    //Texture

    public void show() {

    }

    @Override
    public void render(float delta) {
        ki.camera.update();;
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgUlitsa, 0,0, SCR_WIDTH, SCR_HEIGHT);
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
