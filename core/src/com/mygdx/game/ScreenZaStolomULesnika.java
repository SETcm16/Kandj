package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;

public class ScreenZaStolomULesnika implements Screen {
    KiSH ki;

    Texture imgZaStolom;

    TextButton btnEXIT;

    int N = 9;
    int n = 0;

    String[] text = new String[N];

    public ScreenZaStolomULesnika(KiSH kiSH){
        ki = kiSH;

        imgZaStolom = new Texture("foni/zaStolomULesnika.png");

        btnEXIT = new TextButton(ki.gameFONT, " ВЫЙТИ\n" +
                                                   "В МЕНЮ", 850);

        text[0] = "-КАК ТЫ ЗДЕСЬ ОКАЗАЛСЯ?";
        text[1] = "-Я ИСКАЛ НОЧЛЕГ И ЗАБЛУДИЛСЯ\n" +
                "ДАЖЕ ГРИБЫ СОБРАЛ К УЖИНУ";
        text[2] = "-СПАСИБО ТЕБЕ, ПУТНИК,\n" +
                "НО Я НЕ ЕМ ГРИБЫ";
        text[3] = "-С ЧЕГО ЭТО ВДРУГ?";
        text[4] = "-МОГУ СКАЗАТЬ ОДНО -\n" +
                "ТЕБЕ НЕ ПОВЕЗЛО";
        text[5] = "-ПОЧЕМУ ЖЕ?";
        text[6] = "-Я НЕ ЧЕЛОВЕК\n" +
                "Я - ОБОРОТЕНЬ";
        text[7] = "-И ЧТО МНЕ ДЕЛАТЬ?";
        text[8] = "-ПОСТАРАЙСЯ ОТ МЕНЯ УБЕЖАТЬ,\n" +
                "ИНАЧЕ - СЪЕМ!";
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(Gdx.input.justTouched()){
            ki.touch.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            ki.camera.unproject(ki.touch);
            n++;
            if(btnEXIT.hit(ki.touch.x/2, ki.touch.y)){
                ki.setScreen(ki.screenMenu);
            }
        }

        ki.screenDomLesnikaDva.n = 0;

        if(n>8){
            ki.setScreen(ki.screenDomLesnikaLesTriPobeg);
        }

        ki.camera.update();
        ki.batch.setProjectionMatrix(ki.camera.combined);
        ki.batch.begin();
        ki.batch.draw(imgZaStolom, 0, 0, SCR_WIDTH, SCR_HEIGHT);
        if(n%2 == 0 && n < 9){
            ki.dialogDomStarikFONT.draw(ki.batch, text[n], 570, 850);
        } else if (n < 9) {
            ki.dialogDomStarikFONT.draw(ki.batch, text[n], 1220, 950);
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
        imgZaStolom.dispose();
    }
}
