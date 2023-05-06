package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class ScreenAbout implements Screen {
    KiSH ki;
    Texture imgDomStarika;
    Texture imgAbout;

    String textAbout = "Вы играете за Бродягу, которому нужны\n" +
                        "всего лишь пропитание и ночлег\n\n" +
                       "Игра была разработана по мотивам песен\n" +
                        "группы Король и Шут\n\n\n" +
                          "Приятной игры!";

    TextButton btnExit;

    Sound menuBtnSnd;

    public ScreenAbout(KiSH kiSH) {
        ki = kiSH;
        imgAbout = new Texture("foni/about.png");
        btnExit = new TextButton(ki.exitbtnFONT, "ВЫЙТИ В МЕНЮ", 100);

        menuBtnSnd = Gdx.audio.newSound(Gdx.files.internal("sounds/buttonsound.mp3"));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if(btnExit.hit(ki.touch.x, ki.touch.y)){
                menuBtnSnd.play();
                ki.setScreen(ki.screenMenu);
            }
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgAbout, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        btnExit.font.draw(ki.batch, btnExit.text, btnExit.x, btnExit.y);
        ki.aboutFONT.draw(ki.batch, textAbout, 250, 850);
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
        imgAbout.dispose();
    }
}
