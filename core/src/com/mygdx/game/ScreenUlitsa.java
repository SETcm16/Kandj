package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

import java.awt.TextField;

public class ScreenUlitsa implements Screen{
    KiSH ki;

    Texture imgUlitsa;

    TextButton btnEXIT;

    String text1 = new String();
    String text2 = new String();

    int n = 0;

    Music mscGame;

    public ScreenUlitsa(KiSH kiSH) {
        ki = kiSH;
        imgUlitsa = new Texture("foni/ulitsa1.png");
        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        text1 = "-ПРОВАЛИВАЙ, ТЕБЕ\n" +
                "ТУТ НЕ МЕСТО!";
        text2 = "-ТЫ КТО ТАКОЙ?\n" +
                "Я ТЕБЯ НЕ ЗВАЛ!\n" +
                "ИДИ ОТСЮДА";

        mscGame = Gdx.audio.newMusic(Gdx.files.internal("sounds/mscGame.mp3"));
    }

    public void show() {
        if(ki.screenMenu.musicOn){
            mscGame.play();
            mscGame.setVolume(0.8f);
            mscGame.setLooping(true);
        }
    }

    @Override
    public void render(float delta) {
        //касание кнопки выхода
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if (btnEXIT.hit(ki.touch.x / 2, ki.touch.y)) {
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                mscGame.stop();
                mscGame.setLooping(false);
            }
            //передвижение
            ki.brod.goTo(ki.touch.x);
        }

        // события игры
        if(n>0){
            ki.brod.move();
        }

        if(ki.brod.x < 1800 && ki.brod.x > 1625 && ki.touch.x > 1625 && ki.touch.x < 1800){
            ki.setScreen(ki.screenStarikNaPoroge);
        }



        // отрисовка
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgUlitsa, 0,0, SCR_WIDTH, SCR_HEIGHT);
        if(ki.brod.x < 310 && ki.brod.x > 170 && ki.touch.x > 170 && ki.touch.x < 310){
            ki.dverFONT.draw(ki.batch, text1, 150, 650);
        }
        if(ki.brod.x < 1220 && ki.brod.x > 1080 && ki.touch.x > 1080 && ki.touch.x < 1220){
            ki.dverFONT.draw(ki.batch, text2, 1050, 650);
        }
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.getX(), ki.brod.y, ki.brod.width, ki.brod.height, 0, 0, 253, 587, ki.brod.flip(), false);
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
        imgUlitsa.dispose();
    }
}
