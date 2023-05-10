package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenStarikNaPoroge implements Screen {
    KiSH ki;

    Texture imgStarikNaPoroge;
    Texture imgBrod;

    TextButton btnEXIT;

    String[] text = new String[N];

    int n;
    public static final int N = 3;

    public ScreenStarikNaPoroge(KiSH kiSH){
        ki = kiSH;
        imgStarikNaPoroge = new Texture("foni/starikNaPoroge.png");
        imgBrod = new Texture("geroi/brodyaga.png");
        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
        text[0] = "-Чего тебе\n" +
                "внучок?";
        text[1] = "-Я ищу ночлег\n" +
                "и я очень устал";
        text[2] = "-Гостям я рад,\n" +
                "ты будешь сыт\n" +
                "и отдохнешь";
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if (btnEXIT.hit(ki.touch.x/2, ki.touch.y)) {
                ki.setScreen(ki.screenMenu);
            }
            if(n == N){
                ki.setScreen(ki.screenDomStarika);
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgStarikNaPoroge, 0,0, SCR_WIDTH, SCR_HEIGHT);
        if(n==0 || n==2) {
            ki.dverFONT.draw(ki.batch, text[n], 1550, 650);
        } else ki.dverFONT.draw(ki.batch, text[1], 1500, 550);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        ki.batch.end();
        ki.brod.x = 200;
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
        imgStarikNaPoroge.dispose();
        imgBrod.dispose();
    }
}
