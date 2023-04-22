package com.mygdx.game;

import com.badlogic.gdx.utils.TimeUtils;

public class Brod {
    public static final int SCR_WIDTH = 1920;
    float x, y;
    float shag;
    float width, height;
    float targetX;
    boolean goLeft;
    boolean isGo;
    long timeLastDo;
    long timeInterval = 50L;
    int faza = 0;
    int nFaz = 5;
    float goToX;


    public Brod(float x, float y) {
        this.x = x;
        this.y = y;
        targetX = x;
        width = 400;
        height = 400;
        shag = 40;
    }

    void setTarget(float x){
        targetX = x;
        if(targetX<width/2) targetX=width/2;
        if(targetX>SCR_WIDTH-width/2) targetX=SCR_WIDTH-width/2;
    }

    void goToPlace(float x){
        goToX = x;
        targetX = x;
    }

    void setX(float x){
        this.x = x;
        setTarget(x);
        goToX = 0;
    }

    boolean came(float x){
        return this.x>x-width/2 && this.x<x+width/2;
    }

    void move() {
        if(x != targetX) isGo = true;
        else isGo = false;

        if (timeLastDo + timeInterval < TimeUtils.millis()) {
            timeLastDo = TimeUtils.millis();
            if(Math.abs(x-targetX)< shag) x = targetX;
            if(x<targetX){
                x += shag;
                goLeft = false;
            }
            if(x>targetX){
                x -= shag;
                goLeft = true;
            }

            if(isGo) {
                if (++faza == nFaz) faza = 1;
            }
            else faza = 0;
        }
    }
}
