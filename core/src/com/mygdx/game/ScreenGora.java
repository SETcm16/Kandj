package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.ArrayList;

public class ScreenGora implements Screen {
    KiSH ki;

    Texture imgGora;

    TextButton btnEXIT;

    int n = 0; //чтобы сразу не пошел

    String text = new String();

    boolean gameOver;

    public ScreenGora(KiSH kiSH){
        ki = kiSH;

        imgGora = new Texture("foni/gora.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                                                   "В МЕНЮ", 850);

        text = "ИЗБЕГАЙТЕ ПАДАЮЩИХ КАМНЕЙ!!!";
    }
    @Override
    public void show() {
        ki.brod.faza = 0;
        ki.brod.x = 200;
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if (btnEXIT.hit(ki.touch.x/2, ki.touch.y)) {
                ki.setScreen(ki.screenGoraOver);
            }
            ki.brod.goTo(ki.touch.x);
        }

        if(n == 2){
            ki.setScreen(ki.screenGoraDva);
        }
        ki.screenBlizGori.n = 0;
        gameOver = false;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgGora, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-ki.brod.width/2, 80, ki.brod.width*3/2, ki.brod.height*3/2, 0, 0, 253, 587, ki.brod.flip(), false);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        if(n == 1){
            ki.dverFONT.draw(ki.batch, text, SCR_WIDTH/2-300, SCR_HEIGHT-100);
        }
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
        imgGora.dispose();
    }
}
