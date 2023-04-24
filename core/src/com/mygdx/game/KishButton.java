package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class KishButton {
    float x, y;
    float width, height;
    String text;
    BitmapFont font;
    boolean isScrCenter;

    public KishButton(BitmapFont font, String text, float x, float y, boolean isScrCenter) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
        this.isScrCenter = isScrCenter;
    }

    public void setText(String text) {
        this.text = text;
    }

    public KishButton(BitmapFont font, String text, float x, float y) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        GlyphLayout gl = new GlyphLayout(font, text);
        width = gl.width;
        height = gl.height;
    }


    boolean hit(float tx, float ty){
        return x < tx && tx < x+width && y-height < ty && ty < y;
    }
}
