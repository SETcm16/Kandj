package com.mygdx.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;

public class KiSH extends Game {
    public static final int SCR_HEIGHT = 1080; //разрешение
    public static final int SCR_WIDTH = 1920;

    public static final int MENU = 0; //каждому окну присваем его порядковый номер
    public static int tekuschi_screen;

    public static boolean zad_DVER; //проверка на выполнение задания

    SpriteBatch batch; //рисует картинки
    OrthographicCamera camera; //преобразует разрешение
    Vector3 touch; //отслеживает касания

    BitmapFont introFONT;

    ScreenUlitsa screenUlitsa;//здесь будут окна
    ScreenMenu screenMenu;
    ScreenDomStarika screenDomStarika;


    Texture IMGbrodyaga; //картинки обьявляем

    Brod brod;
    KishButton btnGoMenu; //идем в меню

    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

        generateFonts();

        screenMenu = new ScreenMenu(this);
        setScreen(screenMenu);
        //загрузка персонажей
        //IMGbrodyaga = new Texture();

    }


    void generateFonts(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/introFONT.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = 400;
        parameter.color = Color.DARK_GRAY;
        parameter.borderColor = Color.CORAL;
        parameter.borderWidth = 2;
        introFONT = generator.generateFont(parameter);
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
