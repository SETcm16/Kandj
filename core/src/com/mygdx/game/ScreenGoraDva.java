package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ScreenGoraDva implements Screen {
    KiSH ki;

    Texture imgGora;
    Texture imgKamen;

    ArrayList<Kamen> kamni = new ArrayList<>();

    TextButton btnEXIT;

    long timeStart, timeIgri;
    long timeLastSpawn, timeSpawnInterval = 500;

    public ScreenGoraDva(KiSH kiSH){
        ki = kiSH;

        imgGora = new Texture("foni/gora.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        imgKamen = new Texture("kamen.png");
    }
    @Override
    public void show() {
        ki.brod.faza = 0;
        ki.brod.x = 200;
        ki.brod.y = 80;
        timeStart = TimeUtils.millis();
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
            ki.brod.goTo(ki.touch.x);
        }

        if(TimeUtils.millis() - timeStart < 60000){
            ki.brod.move();
        }

        for (int i = 0; i < kamni.size(); i++) {
            if (ki.brod.overlap(kamni.get(i))){
                ki.setScreen(ki.screenGoraOver);
                kamni.clear();
            }
        }

        timeIgri = TimeUtils.millis() - timeStart;

        if(timeIgri > 60000){
            ki.setScreen(ki.screenKamen);
        }

        spawnKamen();

        for (int i = kamni.size()-1; i >= 0; i--) {
            kamni.get(i).move();
        }
        ki.screenGora.n = 0;

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgGora, 0,0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x-ki.brod.width/2, ki.brod.y, ki.brod.width*3/2, ki.brod.height*3/2, 0, 0, 253, 587, ki.brod.flip(), false);
        ki.introFONT.draw(ki.batch, timeToString(timeIgri), SCR_WIDTH/2-150, 1080);
        for (Kamen kamen : kamni)
            ki.batch.draw(imgKamen, kamen.getX(), kamen.getY(), kamen.width, kamen.height);
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
        imgGora.dispose();
    }


    String timeToString(long time){
        String min = "" + timeIgri/1000/60/10 + time/1000/60%10;
        String sec = "" + timeIgri/1000%60/10 + time/1000%60%10;
        return min+":"+sec;
    }


    void spawnKamen(){
        if(TimeUtils.millis() > timeLastSpawn+timeSpawnInterval) {
            kamni.add(new Kamen());
            timeLastSpawn = TimeUtils.millis();
        }
    }
}
