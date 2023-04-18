package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class KiSH extends ApplicationAdapter {
	public static final int SCR_WIDTH = 1920, SCR_HEIGHT = 1080; //разрешение
	public static final float KX = SCR_WIDTH/1920f;
	public static final float KY = SCR_HEIGHT/1080f; //смена разрешения

	public static final int VSTUPLENIE = 0; //каждому окну присваем его порядковый номер

	public static boolean zad_DVER; //проверка на выполнение задания

	SpriteBatch batch; //рисует картинки
	OrthographicCamera camera;
	Vector3 touch; //отслеживает касания

	BitmapFont introFONT;

	ScreenUlitsa screenUlitsa;//здесь будут окна


	Texture IMGbrodyaga; //картинки обьявляем

	Brodyaga brod;



	@Override
	public void create () {
		this.batch = new SpriteBatch();
		this.camera = new OrthographicCamera();
		this.camera.setToOrtho(false, SCR_WIDTH, SCR_HEIGHT);
		this.touch = new Vector3();

		generateFonts();

		//загрузка персонажей
		//IMGbrodyaga = new Texture();



	}

	void generateFonts(){
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("introFONT.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
		parameter.size = (int)(100*KX);
		parameter.color = Color.DARK_GRAY;
		parameter.borderColor = Color.CORAL;
		parameter.borderWidth = 2;
		introFONT = generator.generateFont(parameter);
	}

	@Override
	public void render () {
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
