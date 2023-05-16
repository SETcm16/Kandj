package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import javax.swing.JFrame;

public class ScreenZamok extends JFrame implements Screen {
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

        ki.screenDomStarika.n = 0;
        ki.screenDomStarika.dialog = true;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgZamok, 0,0, SCR_WIDTH, SCR_HEIGHT);
        if(ki.touch.x>845 && ki.touch.x<930 && ki.touch.y>325 && ki.touch.y<410) {
            odin.font.draw(ki.batch, odin.text, 900, 590);
        }
        if(ki.touch.x>975 && ki.touch.x<1060 && ki.touch.y>325 && ki.touch.y<410){
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
