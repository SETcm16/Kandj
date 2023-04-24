package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.utils.TimeUtils;


public class Brod {
    boolean isVisible = true;
    static float x;
    float y;
    float width, height;
    static float vx;
    float vy;
    long timeStartInvisible, timeInvisibleInterval = 1000;

    public Brod(float x, float y, float width, float height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void move(){
        viletZaGranicu();
        if(!isVisible) {
            if(timeStartInvisible+timeInvisibleInterval< TimeUtils.millis()){
                isVisible = true;
                x = SCR_WIDTH/2;
            }
        }
    }

    static void hit(float tx, float ty) {
        vx = (tx-x)/20;
    }

    public float getX(){
        return x-width/2;
    }

    public float getY(){
        return y-height/2;
    }

    boolean viletZaGranicu() {
        if(x < width/2) {
            x = width/2;
            vx = 0;
        }
        if(x > SCR_WIDTH-width/2){
            x = SCR_WIDTH-width/2;
            vx = 0;
        }
        return true;
    }
}
