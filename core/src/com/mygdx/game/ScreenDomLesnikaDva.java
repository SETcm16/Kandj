package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class  ScreenDomLesnikaDva implements Screen {
    KiSH ki;

    Texture imgDomLesnika;

    TextButton btnEXIT;

    int n = 0;

    String text = new String();
    String text1 = new String();
    String text2 = new String();

    public ScreenDomLesnikaDva(KiSH kiSH){
        ki = kiSH;

        imgDomLesnika = new Texture("foni/domLesnika.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                "В МЕНЮ", 850);

        text = "-ЗДРАВСТВУЙ, ПУТНИК!\n" +
                "БУДЬ КАК ДОМА";

        text1 = "-ЗДРАСТВУЙ, СПАСИБО!";

        text2 = "-ПРОХОДИ ЗА СТОЛ";
    }

    @Override
    public void show() {
        ki.brod.faza = 1;
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if(btnEXIT.hit(ki.touch.x/2, ki.touch.y)){
                ki.setScreen(ki.screenMenu);
                ki.screenMenu.mscMenu.stop();
                ki.screenMenu.mscMenu.setLooping(false);
                ki.screenUlitsa.mscGame.stop();
                ki.screenUlitsa.mscGame.setLooping(false);
            }

            ki.brod.goTo(1129);
            ki.lesnik.goToL(451);
        }

        ki.screenDomLesnikaLesDvaPosleGribov.n = 0;

        if(n>1){
            ki.lesnik.moving();
        }
        if(n>2){
            ki.brod.move();
        }

        if(ki.lesnik.x > 450 && ki.brod.x < 1130){
            ki.setScreen(ki.screenZaStolomULesnika);
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgDomLesnika, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        ki.batch.draw(ki.imgLesnik[ki.lesnik.faza], ki.lesnik.x, 100, ki.lesnik.width*3/2, ki.brod.height*2, 0, 0, 274, 475, ki.lesnik.flip(), false);
        ki.batch.draw(ki.imgBrod[ki.brod.faza], ki.brod.x, 80, ki.brod.width*10/4, ki.brod.height*10/4, 0, 0, 253, 587, ki.brod.flip(), false);
        if (n == 0){
            ki.dialogDomStarikFONT.draw(ki.batch, text, 370, 800);
        }
        if (n == 1){
            ki.dialogDomStarikFONT.draw(ki.batch, text1, 1200, 800);
        }
        if (n == 2){
            ki.dialogDomStarikFONT.draw(ki.batch, text2, 370, 800);
        }
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
        imgDomLesnika.dispose();
    }
}
