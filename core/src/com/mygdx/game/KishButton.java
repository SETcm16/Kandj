package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class KishButton {
    float x;
    float y;
    float width;
    float height;
    float brodIdetTudaPoX;
    String text;
    Texture img;

    KishButton(String text, BitmapFont font, float x, float y){
        this.text = text;
        this.x = x;
        this.y = y;
        GlyphLayout gl = new GlyphLayout(font, text);
        this.width = gl.width;
        this.height = gl.height;
        this.x -= this.width / 2;
    }

    KishButton(float x, float y, float width, float height, float brodIdetTudaPoX){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.brodIdetTudaPoX = brodIdetTudaPoX;
    }

    KishButton(float x, float y, float width, float height, float brodIdetTudaPoX, Texture img){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.brodIdetTudaPoX = brodIdetTudaPoX;
        this.img = img;
    }

    boolean hit(float tx, float ty) {
        if(text == null) return tx > this.x && tx < this.x + this.width && ty > this.y && ty < this.y + this.height;
        return tx > this.x && tx < this.x + this.width && ty < this.y && ty > this.y - this.height;
    }
}
