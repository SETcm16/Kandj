package com.mygdx.game;

import static com.mygdx.game.KiSH.MENU;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenMenu implements Screen {
    final Kandj j;
    public static int current_screen;

    KishButton btnAbout, btnPlay, btnExit;
    Texture imgMenu;

    public ScreenMenu(Kandj j) {
        this.j = j;
        imgMenu = new Texture("foni/menu.jpg");

        //btnAbout = new KishButton("Об игре", j.introFONT, 960, 160);
        //btnPlay = new KishButton("Играть", j.introFONT, 900, 120);
        //btnExit = new KishButton("Выйти", j.introFONT, 840, 80);
    }


    @Override
    public void show() {
        current_screen = MENU;
    }

    @Override
    public void render(float delta) {
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
        imgMenu.dispose();
    }
}
