package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenDomLesnika implements Screen {
    KiSH ki;

    Texture imgDomLesnika;

    TextButton btnEXIT;

    String text = new String();

    int n = 0;

    public ScreenDomLesnika(KiSH kiSH){
        ki = kiSH;

        imgDomLesnika = new Texture("foni/domLesnika.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        text = "-БЛИН, СХОЖУ ХОТЬ ЗА ГРИБАМИ";
    }
    @Override
    public void show() {
        ki.brod.x = 500;
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
                ki.setScreen(ki.screenBlizGori);
            }

            ki.brod.goTo(ki.touch.x);
        }

        if(n > 1){
            ki.brod.move();
        }

        if(ki.brod.x < 300 && ki.touch.x < 300){
            ki.setScreen(ki.screenGribi);
        }

        ki.screenDomLesnikaLes.n = 0;
        ki.screenPosleSboraGribov.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomLesnika, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-ki.brod.width/20, 80, ki.brod.width*10/4, ki.brod.height*10/4, 0, 0, 253, 587, ki.brod.flip(), false);
        if(n == 1){
            ki.dialogDomStarikFONT.draw(ki.batch, text, ki.brod.x + 250, 900);
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
        imgDomLesnika.dispose();
    }
}
