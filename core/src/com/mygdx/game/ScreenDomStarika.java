package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenDomStarika implements Screen {
    KiSH ki;

    Texture imgDomStarika;
    Texture imgBrod;

    TextButton btnEXIT;

    boolean dialog = true;

    int N = 3;
    int n;

    String[] text = new String[N];

    public ScreenDomStarika(KiSH kiSH) {
        ki = kiSH;
        imgBrod = new Texture("geroi/brodyaga.png");
        imgDomStarika = new Texture("foni/domstarika.png");
        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        text[0] = "-ТЫ ДЕД СО МНОЮ НЕ ШУТИ,\n" +
                "СОГРЕЙ И ПРИЮТИ!";
        text[1] = "-НЕ СМЕЮ ГОСТЮ ОТКАЗАТЬ,\n" +
                "ЧТО ХОЧЕШЬ - ТО ПРОСИ";
        text[2] = "-А ЛУЧШЕ В ПОГРЕБ ПОЛЕЗАЙ,\n" +
                "КАРТОШКИ ПРИНЕСИ!";
    }

    @Override
    public void show() {
        ki.brod.faza = 0;
        ki.brod.x = 300;
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
            ki.brod.goTo(ki.touch.x-ki.brod.width*6/5);
        }
        ki.brod.speed = 10;
        if(n > 3) {
            ki.brod.move();
        }

        if(ki.brod.x > 1530 && ki.touch.x > 1530){
            ki.setScreen(ki.screenZamok);
        }

        if(ki.brod.x < 150 && ki.touch.x < 150){
            ki.setScreen(ki.screenUlitsa2);
            ki.brod.x = 1700;
            ki.brod.faza = 0;
        }

        ki.screenUlitsa2.n = 0;
        ki.screenStarikNaPoroge.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomStarika, 0,0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-ki.brod.width/20, 80, ki.brod.width*10/4, ki.brod.height*10/4, 0, 0, 253, 587, ki.brod.flip(), false);
        if(n == 0){
            ki.dialogDomStarikFONT.draw(ki.batch, text[0], ki.brod.x+320, 700);
        }else if(n == 1){
            ki.dialogDomStarikFONT.draw(ki.batch, text[1], 1250, 900);
        } else if( n == 2){
            ki.dialogDomStarikFONT.draw(ki.batch, text[2], 1250, 900);
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
        imgDomStarika.dispose();
        imgBrod.dispose();
    }
}
