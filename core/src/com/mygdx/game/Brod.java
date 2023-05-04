package com.mygdx.game;


public class Brod {
    float x;
    float speed = 20;
    public float vx = 1;
    Brod brod;

    public Brod(float x, float speed){
        this.x = x;
        x = 50;
        this.speed = speed;
    }

    public void move(float x){
        x += vx*speed;
    }

    public float getX(){
        return x;
    }
}

