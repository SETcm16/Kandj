package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenPogrebOne implements Screen {
    KiSH ki;

    Texture imgPogrebPadaet;
    Texture imgPogrebUpal;
    Texture black;
    Texture imgMorg;

    TextButton btnEXIT;

    int n = 0;

    long time;

    public ScreenPogrebOne(KiSH kiSH) {
        ki = kiSH;

        imgPogrebPadaet = new Texture("foni/upalVpogrebe.png");
        imgPogrebUpal = new Texture("foni/naNafig.png");
        black = new Texture("black.png");
        imgMorg = new Texture("foni/morganie.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
    }

    @Override
    public void show() {
        time = TimeUtils.millis();
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
        }

        if(TimeUtils.millis() - time > 4500){
            ki.setScreen(ki.screenLes);
        }

        ki.screenZamok.chislo1 = 0;
        ki.screenZamok.chislo2 = 0;
        ki.screenZamok.chislo3 = 0;
        ki.screenZamok.chislo4 = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        if(TimeUtils.millis() - time < 2000) {
            ki.batch.draw(imgPogrebUpal, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        } else if (TimeUtils.millis() - time > 2000 && TimeUtils.millis() - time < 3500) {
            ki.batch.draw(imgPogrebPadaet, 0,  0, SCR_WIDTH, SCR_HEIGHT);
        } else if(TimeUtils.millis() - time > 3500){
            ki.batch.draw(black, 0, 0, SCR_WIDTH, SCR_HEIGHT);
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
        imgPogrebPadaet.dispose();
        imgPogrebUpal.dispose();
    }
}
