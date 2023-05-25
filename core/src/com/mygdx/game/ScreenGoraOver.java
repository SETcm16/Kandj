package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenGoraOver implements Screen {
    KiSH ki;

    Texture imgGoraOver;

    TextButton btnNewGame;
    TextButton btnEXIT;

    public ScreenGoraOver(KiSH kiSH){
        ki = kiSH;

        imgGoraOver = new Texture("foni/goraOver.png");

        btnNewGame = new TextButton(ki.zamokFONT, "  ПРОЙТИСЬ ПО ГОРАМ\n" +
                                                  "        ЕЩЁ РАЗ", 550);
        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                                                  "В МЕНЮ", 850);
    }

    @Override
    public void show() {
        ki.brod.faza = 0;
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if (btnEXIT.hit(ki.touch.x/2, ki.touch.y)) {
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }

            if(btnNewGame.hit(ki.touch.x, ki.touch.y)){
                ki.setScreen(ki.screenGora);
            }
        }


        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgGoraOver, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        btnNewGame.font.draw(ki.batch, btnNewGame.text, btnNewGame.x, btnNewGame.y);
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
        imgGoraOver.dispose();
    }
}
