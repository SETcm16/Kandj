package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenProigralPobegOtLesnika implements Screen {
    KiSH ki;

    Texture imgProigrish;

    TextButton btnEXIT;
    TextButton btnAgain;

    public ScreenProigralPobegOtLesnika(KiSH kiSH){
        ki =kiSH;

        imgProigrish = new Texture("foni/proigralBegOtLesnika.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        btnAgain = new TextButton(ki.zamokFONT, "СБЕЖАТЬ ЕЩЁ РАЗ", 650);
    }

    @Override
    public void show() {
        ki.oboroten.x = 0;
        ki.brod.x = 450;
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if (btnEXIT.hit(ki.touch.x / 2, ki.touch.y)) {
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }

            if (btnAgain.hit(ki.touch.x, ki.touch.y+300)){
                ki.setScreen(ki.screenDomLesnikaLesTriPobeg);
            }
        }
        ki.brod.x = 450;
        ki.oboroten.x = 0;
        ki.screenDomLesnikaLesTriPobeg.m = 0;
        ki.screenDomLesnikaLesTriPobeg.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgProigrish, 0,0, SCR_WIDTH, SCR_HEIGHT);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        btnAgain.font.draw(ki.batch, btnAgain.text, btnAgain.x, btnAgain.y*2/3);
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
        imgProigrish.dispose();
    }
}
