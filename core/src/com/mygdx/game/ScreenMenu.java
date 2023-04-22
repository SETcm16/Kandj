package com.mygdx.game;

import static com.mygdx.game.KiSH.MENU;
import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScreenMenu implements Screen {
    KiSH ki;
    public static int tekuschi_screen;

    KishButton btnAbout, btnPlay, btnExit;
    Texture imgMenu;

    SpriteBatch batch;

    ScreenMenu(KiSH kish) {
        ki = kish;
        imgMenu = new Texture("foni/menu.jpg");

        btnAbout = new KishButton("Об игре", ki.introFONT, 960, 160);
        btnPlay = new KishButton("Играть", ki.introFONT, 900, 120);
        btnExit = new KishButton("Выйти", ki.introFONT, 840, 80);
    }



    public void show() {
        tekuschi_screen = MENU;
    }


    public void render(float delta) {
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgMenu, 0, 0, SCR_WIDTH, SCR_HEIGHT);
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
    }
}
