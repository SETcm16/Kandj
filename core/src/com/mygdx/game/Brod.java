package com.mygdx.game;


import com.badlogic.gdx.Gdx;

public class Brod {
    float x, y;
    float width, height;
    float speed;
    public static final int RIGHT = 1, LEFT = -1;
    public float direct = RIGHT; // -1 или 1
    public static final int STAY = 0, GO = 1;
    public int state = STAY;
    int faza = 1, nFaz = 2;
    float target;

    public Brod(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move(){
        if(state == GO) {
            x += direct * speed;
            if (direct == RIGHT && x > target || direct == LEFT && x < target) {
                speed = 0;
                x = target;
                state = STAY;
            }
            if(++faza==nFaz+1) faza = 1;
        }
        if(state == STAY) {
            faza = 0;
        }
    }

    public void goTo(float tx) {
        target = tx;
        speed = 20;
        state = GO;
        if(tx > x) {
            direct = RIGHT;
        } else {
            direct = LEFT;
        }
    }

    float getX() {
        return x-width/2;
    }

    boolean flip() {
        if(direct == LEFT){
            return true;
        } else {
            return false;
        }
    }
}

