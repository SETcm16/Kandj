package com.mygdx.game;


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
    public static final float SCR_WIDTH = 1920; //разрешение
    public static final float SCR_HEIGHT = 1080;

    public static final int MENU = 0, ULITSA = 1, DOMSTARIKA = 2; //каждому окну присваем его порядковый номер
    public static int tekuschi_screen;

    public static boolean zad_DVERSULITSI, zad_DVERPOGREBA;//проверка на выполнение задания
    public static boolean zad_GRIBI, zad_BITVASOBOROTNEM;
    public static boolean zad_GORA;
    public static boolean zad_IGRAODIN, zad_IGREDVA, zad_IGRATRI;
    public static boolean zad_MERTVECI;
    public static boolean zad_VPOGREBEZHIZN;
    public static boolean isHOCHETIGRAT;


    SpriteBatch batch; //рисует картинки
    OrthographicCamera camera; //преобразует разрешение
    Vector3 touch; //отслеживает касания

    BitmapFont introFONT;
    BitmapFont aboutFONT;
    BitmapFont gameFONT;
    BitmapFont exitbtnFONT;
    BitmapFont dialogFONT;

    ScreenUlitsa screenUlitsa;//здесь будут окна
    ScreenMenu screenMenu;
    ScreenAbout screenAbout;
    ScreenDomStarika screenDomStarika;
    ScreenStarikNaPoroge screenStarikNaPoroge;
    ScreenZamok screenZamok;


    Texture IMGbrodyaga; //картинки обьявляем

    Brod brod;
    TextButton btnGoMenu; //идем в меню

    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

        generateFonts();

        screenMenu = new ScreenMenu(this);
        screenUlitsa = new ScreenUlitsa(this);
        screenAbout = new ScreenAbout(this);
        screenDomStarika = new ScreenDomStarika(this);
        screenStarikNaPoroge = new ScreenStarikNaPoroge(this);
        screenZamok = new ScreenZamok(this);
        setScreen(screenMenu);

    }


    void generateFonts(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/introFONT.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = 120;
        parameter.color = Color.DARK_GRAY;
        parameter.borderColor = Color.CORAL;
        parameter.borderWidth = 3;
        introFONT = generator.generateFont(parameter);
        parameter.size = 60;
        parameter.color = Color.FOREST;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 2;
        aboutFONT = generator.generateFont(parameter);
        parameter.size = 30;
        parameter.borderWidth = 0;
        parameter.color = Color.FIREBRICK;
        gameFONT = generator.generateFont(parameter);
        parameter.size = 50;
        parameter.color = Color.BROWN;
        exitbtnFONT = generator.generateFont(parameter);
        generator.dispose();

        FreeTypeFontGenerator generator1 = new FreeTypeFontGenerator(Gdx.files.internal("fonts/about.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter1 = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
        parameter.size = 150;
        parameter.color = Color.FOREST;
        dialogFONT = generator1.generateFont(parameter1);

    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
