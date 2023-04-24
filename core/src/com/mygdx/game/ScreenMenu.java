package com.mygdx.game;

import static com.mygdx.game.KiSH.MENU;
import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ScreenMenu implements Screen {
    KiSH ki;
    public static int tekuschi_screen;

    KishButton btnAbout, btnPlay, btnExit;
    Texture imgMenu;
    Texture imgBrod;

    SpriteBatch batch;



    ScreenMenu(KiSH kish) {
        ki = kish;
        imgMenu = new Texture("foni/menu.jpg");

        btnAbout = new KishButton(ki.introFONT, "Предыстория", SCR_WIDTH/2, SCR_HEIGHT/2+200);
        btnPlay = new KishButton(ki.introFONT, "Начать историю", 900, 120);
        btnExit = new KishButton(ki.introFONT, "Выйти", 840, 80);
    }



    public void show() {
    }


    public void render(float delta) {
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if(btnPlay.hit(ki.touch.x, ki.touch.y)){
                ki.setScreen(ki.screenUlitsa);
            }
            if(btnAbout.hit(ki.touch.x, ki.touch.y)){
                ki.setScreen(ki.screenAbout);
            }
            if(btnExit.hit(ki.touch.x, ki.touch.y)){
                Gdx.app.exit();
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgMenu, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnPlay.font.draw(ki.batch, btnPlay.text, SCR_WIDTH/2-btnPlay.width/2, SCR_HEIGHT/2+btnPlay.height*5/2);
        btnAbout.font.draw(ki.batch, btnAbout.text, SCR_WIDTH/2-btnAbout.width/2, SCR_HEIGHT/2+btnAbout.height/2);
        btnExit.font.draw(ki.batch, btnExit.text, SCR_WIDTH/2- btnExit.width/2, SCR_HEIGHT/2-btnExit.height*3/2);
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
