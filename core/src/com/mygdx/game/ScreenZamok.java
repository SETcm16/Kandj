package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class ScreenZamok implements Screen {
    KiSH ki;

    TextButton btnEXIT;
    TextButton odin, dva;

    Texture imgZamok;

    public ScreenZamok(KiSH kiSH){
        ki = kiSH;

        imgZamok = new Texture("foni/zamok.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
        odin = new TextButton(ki.zamokFONT, "1", 1000, 800);
        dva = new TextButton(ki.zamokFONT, "2", 1100, 800);
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
                ki.setScreen(ki.screenPogrebOne);
            }

        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgZamok, 0,0, SCR_WIDTH, SCR_HEIGHT);
        if(Gdx.input.getX()>845 && Gdx.input.getX()<930 && Gdx.input.getY()>670 && Gdx.input.getY()<755) {
            odin.font.draw(ki.batch, odin.text, 900, 590);
        }
        if(Gdx.input.getX()>975 && Gdx.input.getX()<1060 && Gdx.input.getY()>670 && Gdx.input.getY()<755){
            dva.font.draw(ki.batch, dva.text, 1000, 590);
        }
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
        imgZamok.dispose();
    }
}
