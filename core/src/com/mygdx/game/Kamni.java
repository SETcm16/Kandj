package com.mygdx.game;

public class Kamni {
    float x, y;
    float width, height;
    float vy;

    public Kamni(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    void move(){
        y += vy;
    }

    public float getX(){
        return x - width/2;
    }

    public float getY(){
        return y - height/2;
    }
}
