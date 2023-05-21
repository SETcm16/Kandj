package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

public class ScreenDomLesnikaLesTriPobeg implements Screen {
    KiSH ki;

    Texture imgDomLesnikaLesDva;
    Texture imgLesnik2;

    TextButton btnEXIT;

    int n = 0; //анимация
    int m = 0; //шаг

    String text = new String();

    long timeSTART;

    public ScreenDomLesnikaLesTriPobeg(KiSH kiSH){
        ki = kiSH;

        imgDomLesnikaLesDva = new Texture("foni/les.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        imgLesnik2 = new Texture("geroi/lesnik2faza.png");

        text = "ЧАЩЕ НАЖИМАЙ НА ЭКРАН!";
    }
    @Override
    public void show() {
        ki.brod.x = 450;
        ki.brod.speed = 0;
        ki.brod.faza = 0;
        ki.lesnik.faza = 0;
        ki.lesnik.flip();
        timeSTART = TimeUtils.millis();
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

            ki.brod.goTo(ki.touch.x);
            ki.oboroten.goToO(1630);
        }

        if(TimeUtils.millis() - timeSTART > 2000){
            ki.oboroten.moved();
        }

        if(TimeUtils.millis() - timeSTART > 2000){
            ki.brod.move();
        }

        if(ki.oboroten.x + 120 > ki.brod.x){
            ki.setScreen(ki.screenProigralPobegOtLesnika);
        }

        if(ki.brod.x > 1800){
            ki.setScreen(ki.screenBlizGori);
        }

        if (Gdx.input.isTouched()){
            if(TimeUtils.millis() - timeSTART > 2000) {
                m++;
                ki.brod.speed = (float) (ki.brod.speed + m * 0.1);
            } else {
                ki.brod.speed = 0;
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomLesnikaLesDva, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.skolkoFONT.draw(ki.batch, text, 0, 1050);
        if(TimeUtils.millis() - timeSTART < 999) {
            ki.batch.draw(ki.imgLesnik[ki.lesnik.faza], 0, 70, 290, 477, 0, 0, 290, 477, ki.lesnik.flip(), false);
        }
        if (TimeUtils.millis() - timeSTART > 1000 && TimeUtils.millis() - timeSTART < 1999){
            ki.batch.draw(imgLesnik2, 0,  70, 340, 477);
        }
        if(TimeUtils.millis() - timeSTART > 2000){
            ki.batch.draw(ki.imgObor[ki.oboroten.faza], ki.oboroten.x, 70, ki.oboroten.width, ki.oboroten.height);
        }
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-80, 70, ki.brod.width*12/10, ki.brod.height*12/10, 0, 0, 253, 587, ki.brod.flip(), false);
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
        imgDomLesnikaLesDva.dispose();
    }
}
