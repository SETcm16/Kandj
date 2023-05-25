package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenMenu implements Screen {
    KiSH ki;

    TextButton btnAbout, btnPlay, btnExit, btnSettings;
    Texture imgMenu;

    SpriteBatch batch;

    Sound menuBtnSnd;

    Music mscMenu;

    int k = 0;

    boolean musicOn = true;

    ScreenMenu(KiSH kish) {
        ki = kish;
        imgMenu = new Texture("foni/menu.jpg");
        btnPlay = new TextButton(ki.introFONT, "Начать историю", 550);
        btnAbout = new TextButton(ki.introFONT, "Предыстория", 417);
        btnExit = new TextButton(ki.introFONT, "Выйти", 150);
        btnSettings = new TextButton(ki.introFONT, "МУЗЫКА: ВКЛ", 283);

        menuBtnSnd = Gdx.audio.newSound(Gdx.files.internal("sounds/buttonsound.mp3"));

        mscMenu = Gdx.audio.newMusic(Gdx.files.internal("sounds/menuSound.mp3"));
    }

    public void show() {
    }

    public void render(float delta) {
        // касания
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if(btnPlay.hit(ki.touch.x, ki.touch.y)){
                menuBtnSnd.play();
                mscMenu.setLooping(false);
                mscMenu.stop();
                ki.setScreen(ki.screenUlitsa);
            }
            if(btnAbout.hit(ki.touch.x, ki.touch.y)){
                menuBtnSnd.play();
                ki.setScreen(ki.screenAbout);
            }
            if(btnExit.hit(ki.touch.x, ki.touch.y)){
                Gdx.app.exit();
            }
            if(btnSettings.hit(ki.touch.x, ki.touch.y)){
                musicOn = !musicOn;
                if(musicOn) btnSettings.text = "МУЗЫКА: ВКЛ";
                else btnSettings.text = "МУЗЫКА: ВЫКЛ";
            }
        }

        if(musicOn && !btnPlay.hit(ki.touch.x, ki.touch.y)) {
            mscMenu.play();
            mscMenu.setVolume(0.8f);
            mscMenu.setLooping(true);
        } else {
            mscMenu.stop();
        }

        ki.screenUlitsa.n = 0;
        ki.screenStarikNaPoroge.n = 0;
        ki.screenDomStarika.n = 0;
        ki.screenUlitsa2.n = 0;
        ki.screenZamok.chislo1 = 0;
        ki.screenZamok.chislo2 = 0;
        ki.screenZamok.chislo3 = 0;
        ki.screenZamok.chislo4 = 0;
        ki.screenPogrebOne.n = 0;
        ki.screenLes.n = 0;
        ki.screenDomLesnikaLes.n = 0;
        ki.screenDomLesnika.n = 0;
        ki.screenGribi.n = 0;
        ki.screenDomLesnikaLesDvaPosleGribov.n = 0;
        ki.screenDomLesnikaDva.n = 0;
        ki.screenDomLesnikaLesTriPobeg.n = 0;
        ki.screenBlizGori.n = 0;
        ki.screenGora.n = 0;

        // отрисовка
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgMenu, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(ki.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnAbout.font.draw(ki.batch, btnAbout.text, btnAbout.x, btnAbout.y);
        btnSettings.font.draw(ki.batch, btnSettings.text, btnSettings.x, btnSettings.y);
        btnExit.font.draw(ki.batch, btnExit.text, btnExit.x, btnExit.y);
        ki.batch.end();
    }

    public void resize(int width, int height) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void hide() {

    }

    public void dispose() {
        imgMenu.dispose();
        batch.dispose();
    }
}
