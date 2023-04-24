package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    KiSH ki;

    Texture imgMenu;

    public ScreenAbout(KiSH kish){
        ki = kish;
        imgMenu = new Texture("foni/menu.jpg");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgMenu, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        //ki.font.draw(ki.batch, textAbout);
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

    }
}
