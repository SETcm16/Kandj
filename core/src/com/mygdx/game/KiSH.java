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

    SpriteBatch batch; //рисует картинки
    OrthographicCamera camera; //преобразует разрешение
    Vector3 touch; //отслеживает касания

    BitmapFont introFONT;
    BitmapFont aboutFONT;
    BitmapFont gameFONT;
    BitmapFont exitbtnFONT;
    BitmapFont zamokFONT;
    BitmapFont dverFONT;
    BitmapFont dialogDomStarikFONT;
    BitmapFont skolkoFONT;

    ScreenUlitsa screenUlitsa;//здесь будут окна
    ScreenMenu screenMenu;
    ScreenAbout screenAbout;
    ScreenDomStarika screenDomStarika;
    ScreenUlitsa2 screenUlitsa2;
    ScreenStarikNaPoroge screenStarikNaPoroge;
    ScreenZamok screenZamok;
    ScreenPogrebOne screenPogrebOne;
    ScreenLes screenLes;
    ScreenDomLesnikaLes screenDomLesnikaLes;
    ScreenDomLesnika screenDomLesnika;
    ScreenGribi screenGribi;
    ScreenDomLesnikaLesDvaPosleGribov screenDomLesnikaLesDvaPosleGribov;
    ScreenDomLesnikaDva screenDomLesnikaDva;
    ScreenZaStolomULesnika screenZaStolomULesnika;
    ScreenDomLesnikaLesTriPobeg screenDomLesnikaLesTriPobeg;
    ScreenProigralPobegOtLesnika screenProigralPobegOtLesnika;
    ScreenBlizGori screenBlizGori;
    ScreenGora screenGora;
    ScreenGoraOver screenGoraOver;
    ScreenGoraDva screenGoraDva;
    ScreenKamen screenKamen;
    ScreenPogrebTwo screenPogrebTwo;
    ScreenPogrebTRI screenPogrebTRI;

    Brod brod;
    Texture[] imgBrod = new Texture[5];

    Lesnik lesnik;
    Texture[] imgLesnik = new Texture[5];

    Oboroten oboroten;
    Texture[] imgObor = new Texture[4];

    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
        touch = new Vector3();

        generateFonts();

        imgBrod[0] = new Texture("geroi/brodyaga.png");
        imgBrod[1] = new Texture("geroi/brod1.png");
        imgBrod[2] = new Texture("geroi/brod2.png");
        imgBrod[3] = new Texture("geroi/brod3.png");
        imgBrod[4] = new Texture("geroi/brod4.png");
        imgLesnik[0] = new Texture("geroi/lesnik1.png");
        imgLesnik[1] = new Texture("geroi/lesnik2.png");
        imgLesnik[2] = new Texture("geroi/lesnik3.png");
        imgLesnik[3] = new Texture("geroi/lesnik4.png");
        imgLesnik[4] = new Texture("geroi/lesnik5.png");
        imgObor[0] = new Texture("geroi/obor1.png");
        imgObor[1] = new Texture("geroi/obor2.png");
        imgObor[2] = new Texture("geroi/obor3.png");
        imgObor[3] = new Texture("geroi/obor4.png");
        screenMenu = new ScreenMenu(this);
        screenUlitsa = new ScreenUlitsa(this);
        screenUlitsa2 = new ScreenUlitsa2(this);
        screenAbout = new ScreenAbout(this);
        screenDomStarika = new ScreenDomStarika(this);
        screenStarikNaPoroge = new ScreenStarikNaPoroge(this);
        screenZamok = new ScreenZamok(this);
        screenPogrebOne = new ScreenPogrebOne(this);
        screenLes = new ScreenLes(this);
        screenDomLesnikaLes = new ScreenDomLesnikaLes(this);
        screenDomLesnika = new ScreenDomLesnika(this);
        screenGribi = new ScreenGribi(this);
        screenBlizGori = new ScreenBlizGori(this);
        screenGora = new ScreenGora(this);
        screenKamen = new ScreenKamen(this);
        screenGoraOver = new ScreenGoraOver(this);
        screenGoraDva = new ScreenGoraDva(this);
        screenDomLesnikaLesDvaPosleGribov = new ScreenDomLesnikaLesDvaPosleGribov(this);
        screenDomLesnikaDva = new ScreenDomLesnikaDva(this);
        screenZaStolomULesnika = new ScreenZaStolomULesnika(this);
        screenDomLesnikaLesTriPobeg = new ScreenDomLesnikaLesTriPobeg(this);
        screenProigralPobegOtLesnika = new ScreenProigralPobegOtLesnika(this);
        screenPogrebTwo = new ScreenPogrebTwo(this);
        screenPogrebTRI = new ScreenPogrebTRI(this);
        brod = new Brod(120, 176, 130, 300);
        lesnik = new Lesnik(0, 290, 477, 7);
        oboroten = new Oboroten(0, 249, 474, 10);
        setScreen(screenGora);

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
        parameter.size = 90;
        parameter.color = Color.WHITE;
        parameter.borderColor = Color.BLACK;
        parameter.borderWidth = 2;
        zamokFONT = generator.generateFont(parameter);
        parameter.size = 40;
        parameter.color = Color.DARK_GRAY;
        dverFONT = generator.generateFont(parameter);
        parameter.size = 30;
        parameter.color = Color.ORANGE;
        dialogDomStarikFONT = generator.generateFont(parameter);
        parameter.size = 60;
        parameter.color = Color.DARK_GRAY;
        parameter.borderColor = Color.CORAL;
        parameter.borderWidth = 3;
        skolkoFONT = generator.generateFont(parameter);
        generator.dispose();
    }

    @Override
    public void dispose () {
        batch.dispose();
        for (int i = 0; i < imgBrod.length; i++) {
            imgBrod[i].dispose();
        }
    }

}
