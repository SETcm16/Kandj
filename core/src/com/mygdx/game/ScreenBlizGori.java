package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenBlizGori implements Screen {
    KiSH ki;

    Texture imgBlizGori;

    TextButton btnEXIT;

    int n = 0;

    public ScreenBlizGori(KiSH kiSH){
        ki = kiSH;

        imgBlizGori = new Texture("foni/blizGori.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
    }
    @Override
    public void show() {
        ki.brod.x = 100;
        ki.brod.speed = 0;
        ki.brod.faza = 0;
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if (btnEXIT.hit(ki.touch.x/2, ki.touch.y)) {
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }
            ki.brod.goTo(ki.touch.x);
        }
        if(n>0) {
            ki.brod.move();
        }

        if (ki.brod.x > 1850 && ki.touch.x >1850){
            ki.setScreen(ki.screenGora);
        }

        ki.screenDomLesnika.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgBlizGori, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.getX(), ki.brod.y-96, ki.brod.width, ki.brod.height, 0, 0, 253, 587, ki.brod.flip(), false);
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
        imgBlizGori.dispose();
    }
}
