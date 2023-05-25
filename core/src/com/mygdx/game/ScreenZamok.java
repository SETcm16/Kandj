package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import javax.swing.JFrame;

public class ScreenZamok implements Screen {
    KiSH ki;

    TextButton btnEXIT;
    TextButton btnVIITI;

    int chislo1 = 0;
    int chislo2 = 0;
    int chislo3 = 0;
    int chislo4 = 0;

    Texture imgZamok;
    Texture pod;

    public ScreenZamok(KiSH kiSH){
        ki = kiSH;

        imgZamok = new Texture("foni/zamok.png");
        pod = new Texture("podskazka.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);
        btnVIITI = new TextButton(ki.gameFONT, "НАЗАД", 850);
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
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }
        }

        ki.screenDomStarika.n = 4;
        ki.screenDomStarika.dialog = true;

        if(chislo1 == 6 && chislo2 == 8 && chislo3 == 6 && chislo4 == 9){
            ki.setScreen(ki.screenPogrebOne);
        }

        if(ki.touch.x < 130 && ki.touch.y > 900){
            ki.setScreen(ki.screenDomStarika);
            ki.brod.x = 1450;
            ki.brod.faza = 0;
            ki.brod.speed = 0;
        }

        if(Gdx.input.justTouched() && ki.touch.x > 810 && ki.touch.x < 935 && ki.touch.y > 263 && ki.touch.y < 435){
            chislo1++;
            if(chislo1 > 9){
                chislo1 = 0;
            }
        }
        if(Gdx.input.justTouched() && ki.touch.x > 940 && ki.touch.x < 1065 && ki.touch.y > 263 && ki.touch.y < 435){
            chislo2++;
            if(chislo2 > 9){
                chislo2 = 0;
            }
        }
        if(Gdx.input.justTouched() && ki.touch.x > 1070 && ki.touch.x < 1195 && ki.touch.y > 263 && ki.touch.y < 435){
            chislo3++;
            if(chislo3 > 9){
                chislo3 = 0;
            }
        }
        if(Gdx.input.justTouched() && ki.touch.x > 1200 && ki.touch.x < 1325 && ki.touch.y > 263 && ki.touch.y < 435){
            chislo4++;
            if(chislo4 > 9){
                chislo4 = 0;
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgZamok, 0,0, SCR_WIDTH, SCR_HEIGHT);
        ki.introFONT.draw(ki.batch, String.valueOf(chislo1), 845, 445);
        ki.introFONT.draw(ki.batch, String.valueOf(chislo2), 970, 445);
        ki.introFONT.draw(ki.batch, String.valueOf(chislo3), 1095, 445);
        ki.introFONT.draw(ki.batch, String.valueOf(chislo4), 1220, 445);
        ki.batch.draw(pod, 1480, 180, 407, 386);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        btnVIITI.font.draw(ki.batch, btnVIITI.text, btnEXIT.x*0, btnEXIT.y);
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
