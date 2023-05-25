package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScreenGribi implements Screen {
    KiSH ki;

    Texture imgGribi, imgLitva1, imgLitva2;
    Texture grib1, grib2, grib3, grib4, grib5, grib6;

    TextButton btnEXIT;

    boolean sobralGrib1 = false, sobralGrib2 = false, sobralGrib3 = false, sobralGrib4 = false, sobralGrib5 = false, sobralGrib6 = false;

    String text = new String();

    int n = 0;

    public ScreenGribi(KiSH kiSH){
        ki = kiSH;

        imgGribi = new Texture("foni/les.png");
        imgLitva1 = new Texture("foni/litva.png");
        imgLitva2 = new Texture("foni/litva2.png");
        grib1 = new Texture("grib.png");
        grib2 = new Texture("grib.png");
        grib3 = new Texture("grib.png");
        grib4 = new Texture("grib.png");
        grib5 = new Texture("grib.png");
        grib6 = new Texture("grib.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        text = "ТЫ СОБРАЛ ВСЕ ГРИБЫ!\n" +
                "     ИДИ К ДОМУ\n" +
                "          <--";
    }

    @Override
    public void show() {
        ki.screenDomLesnika.show();
        ki.brod.x = 100;
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
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }
            ki.brod.goTo(ki.touch.x);
        }
        if(n>0) {
            ki.brod.move();
        }

        if(ki.touch.x > 1830 && ki.touch.x < 1880 && ki.brod.x > 1830 && ki.brod.x < 1880){
            sobralGrib1 = true;
        }
        if(ki.touch.x > 240 && ki.touch.x < 310 && ki.brod.x > 240 && ki.brod.x < 310){
            sobralGrib2 = true;
        }
        if(ki.touch.x > 760 && ki.touch.x < 840 && ki.brod.x > 760 && ki.brod.x < 840){
            sobralGrib3 = true;
        }
        if(ki.touch.x > 450 && ki.touch.x < 510 && ki.brod.x > 450 && ki.brod.x < 510){
            sobralGrib4 = true;
        }
        if(ki.touch.x > 1000 && ki.touch.x < 1050 && ki.brod.x > 1000 && ki.brod.x < 1050){
            sobralGrib5 = true;
        }
        if(ki.touch.x > 1440 && ki.touch.x < 1508 && ki.brod.x > 1440 && ki.brod.x < 1508){
            sobralGrib6 = true;
        }

        ki.screenDomLesnika.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgGribi, 0, 0, SCR_WIDTH, SCR_HEIGHT);


        if(!sobralGrib4) {
            ki.batch.draw(grib4, 450, 100, 60, 60);
        }
        if(!sobralGrib5) {
            ki.batch.draw(grib5, 1000, 92, 55, 55);
        }
        if(!sobralGrib6) {
            ki.batch.draw(grib6, 1440, 92, 68, 68);
        }

        ///////////////////////////////////////////////////////////////////////////////////
        ki.batch.draw(imgLitva2, 0, 92, SCR_WIDTH, 83); //листва заднего плана
        if(!sobralGrib1) {
            ki.batch.draw(grib1, 1830, 92, 50, 50);
        }
        if(!sobralGrib2) {
            ki.batch.draw(grib2, 240, 92, 70, 70);
        }
        if(!sobralGrib3) {
            ki.batch.draw(grib3, 760, 92, 35, 35);
        }
        ///////////////////////////////////////////////////////////////////////////////////
        ki.batch.draw(imgLitva1, 0, 92, SCR_WIDTH, 83); //листва переднего плана

        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-80, 70, ki.brod.width*12/10, ki.brod.height*12/10, 0, 0, 253, 587, ki.brod.flip(), false);
        btnEXIT.font.draw(ki.batch, btnEXIT.text, btnEXIT.x*500/251, btnEXIT.y);
        if(sobralGrib1 && sobralGrib2 && sobralGrib3 && sobralGrib4 && sobralGrib5 && sobralGrib6){
            ki.skolkoFONT.draw(ki.batch, text, SCR_WIDTH/2-350, 1050);
        }
        if(sobralGrib1 && sobralGrib2 && sobralGrib3 && sobralGrib4 && sobralGrib5 && sobralGrib6 && ki.brod.x < 150 && ki.touch.x < 150){
            ki.setScreen(ki.screenDomLesnikaLesDvaPosleGribov);
        }
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
        imgGribi.dispose();
    }
}
