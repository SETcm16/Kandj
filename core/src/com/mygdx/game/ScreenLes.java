package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenLes implements Screen {
    KiSH ki;

    Texture imgLes;
    Texture imgProsnulsya;

    TextButton btnEXIT;

    int n = 0;

    long time;

    public ScreenLes(KiSH kiSH){
        ki = kiSH;

        imgLes = new Texture("foni/les1.png");
        imgProsnulsya = new Texture("foni/VLesuBuhoy.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
    }
    @Override
    public void show() {
        ki.brod.x = 100;
        ki.brod.speed = 0;
        ki.brod.faza = 0;
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

            ki.brod.goTo(ki.touch.x);
        }
        if(n > 0) {
            ki.brod.move();
        }

        if(ki.brod.x > 1800){
            ki.setScreen(ki.screenDomLesnikaLes);
        }

        ki.brod.speed = 7;

        ki.screenPogrebOne.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        if(TimeUtils.millis() - time < 1500) {
            ki.batch.draw(imgProsnulsya, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        } else if (TimeUtils.millis() - time > 1500){
            ki.batch.draw(imgLes, 0, 0, SCR_WIDTH, SCR_HEIGHT);
            ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x - 80, 70, ki.brod.width * 12 / 10, ki.brod.height * 12 / 10, 0, 0, 253, 587, ki.brod.flip(), false);
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
        imgLes.dispose();
    }
}
