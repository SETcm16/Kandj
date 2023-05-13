package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_WIDTH;

public class Lesnik {
    float x, y;
    float width, height;
    float speed;
    public static final int RIGHTL = 1, LEFTL = -1;
    public float directL = RIGHTL; // -1 или 1
    public static final int STAYL = 0, GOL = 1;
    public int stateL = STAYL;
    int faza = 1, nFaz = 4;
    float target;


    public Lesnik(float x, float width, float height, float speed) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void moving(){
        if(stateL == GOL) {
            x += directL * speed;
            if (directL == RIGHTL && x > target || directL == LEFTL && x < target) {
                speed = 0;
                x = target;
                stateL = STAYL;
            }
            if(++faza==nFaz+1) faza = 1;
        }
        if(stateL == STAYL) {
            faza = 0;
        }

        if(x<width/2){
            x = width/2;
            speed = 0;
            stateL = STAYL;
        } else if (x > SCR_WIDTH - width/2) {
            x = SCR_WIDTH - width/2;
            speed = 0;
            stateL = STAYL;
        }
    }


    public void goToL(float tx) {
        target = tx;
        speed = 7;
        stateL = GOL;
        if(tx > x) {
            directL = RIGHTL;
        } else {
            directL = LEFTL;
        }
    }

    float getX() {
        return x-width/2;
    }

    boolean flip() {
        if(directL == LEFTL){
            return true;
        } else {
            return false;
        }
    }

}
