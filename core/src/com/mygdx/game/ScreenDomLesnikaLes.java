package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenDomLesnikaLes implements Screen {
    KiSH ki;

    Texture imgDomLesnikaLes;

    TextButton btnEXIT;

    public ScreenDomLesnikaLes(KiSH kiSH){
        ki = kiSH;

        imgDomLesnikaLes = new Texture("foni/domLesnikaLes.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                                              "В МЕНЮ", 860);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if (btnEXIT.hit(ki.touch.x/2, ki.touch.y)) {
                ki.setScreen(ki.screenDomLesnika);
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomLesnikaLes, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
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
        imgDomLesnikaLes.dispose();
    }
}
