package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenDomLesnikaDva implements Screen {
    KiSH ki;

    Texture imgDomLesnika;

    TextButton btnEXIT;

    int n = 0;

    public ScreenDomLesnikaDva(KiSH kiSH){
        ki = kiSH;

        imgDomLesnika = new Texture("foni/domLesnika.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if(btnEXIT.hit(ki.touch.x, ki.touch.y)){
                ki.setScreen(ki.screenMenu);
            }

            ki.brod.goTo(ki.touch.x);
        }

        if(n>0){
            ki.brod.move();
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomLesnika, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgLesnik[ki.lesnik.faza], ki.lesnik.x, 100, ki.lesnik.width*2, ki.brod.height*2, 0, 0, 368, 477, ki.lesnik.flip(), false);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x, 80, ki.brod.width*10/4, ki.brod.height*10/4, 0, 0, 253, 587, ki.brod.flip(), false);
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

    }
}
