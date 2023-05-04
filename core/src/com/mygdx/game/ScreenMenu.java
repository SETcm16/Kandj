package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenMenu implements Screen {
    KiSH ki;

    TextButton btnAbout, btnPlay, btnExit;
    Texture imgMenu;

    SpriteBatch batch;

    Sound menuBtnSnd;

    ScreenMenu(KiSH kish) {
        ki = kish;
        imgMenu = new Texture("foni/menu.jpg");
        btnPlay = new TextButton(ki.introFONT, "Начать историю", 520);
        btnAbout = new TextButton(ki.introFONT, "Предыстория", 335);
        btnExit = new TextButton(ki.introFONT, "Выйти", 150);

        menuBtnSnd = Gdx.audio.newSound(Gdx.files.internal("sounds/buttonsound.mp3"));
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
                ki.setScreen(ki.screenUlitsa);
            }
            if(btnAbout.hit(ki.touch.x, ki.touch.y)){
                menuBtnSnd.play();
                ki.setScreen(ki.screenAbout);
            }
            if(btnExit.hit(ki.touch.x, ki.touch.y)){
                Gdx.app.exit();
            }
        }

        // отрисовка
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgMenu, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(ki.batch, btnPlay.text, btnPlay.x, btnPlay.y);
        btnAbout.font.draw(ki.batch, btnAbout.text, btnAbout.x, btnAbout.y);
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
