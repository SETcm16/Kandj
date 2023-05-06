package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class ScreenUlitsa implements Screen{
    KiSH ki;

    Texture imgUlitsa;

    TextButton btnEXIT;

    public ScreenUlitsa(KiSH kiSH) {
        ki = kiSH;
        imgUlitsa = new Texture("foni/ulitsa1.jpg");
        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 860);
    }

    public void show() {
    }

    @Override
    public void render(float delta) {
        //касание кнопки выхода
        if(Gdx.input.justTouched()) {
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            if (btnEXIT.hit(ki.touch.x / 2, ki.touch.y)) {
                ki.setScreen(ki.screenStarikNaPoroge);
            }
            //передвижение
            ki.brod.goTo(ki.touch.x);
        }

        // события игры
        ki.brod.move();
        /*if(Gdx.input.getX()<1460 && Gdx.input.getX()>1200){
            ki.setScreen(ki.screenStarikNaPoroge);
        }*/

        // отрисовка
        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgUlitsa, 0,0, SCR_WIDTH, SCR_HEIGHT);
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
