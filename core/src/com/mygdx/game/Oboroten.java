package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.utils.TimeUtils;

public class Oboroten {
    float x, y;
    float width, height;
    float speed;
    public static final int RIGHTO = 1, LEFTO = -1;
    public float directO = RIGHTO; // -1 или 1
    public static final int STAYO = 0, GOO = 1;
    public int stateO = STAYO;
    int faza = 0, nFaz = 3;
    float target;
    long timeLastShag, timeIntervalShaga = 50;

    public Oboroten(float x, float width, float height, float speed) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public void moved(){
        if(stateO == GOO) {
            x += directO * speed;
            if (directO == RIGHTO && x > target || directO == LEFTO && x < target) {
                speed = 0;
                x = target;
                stateO = STAYO;
            }
            if (TimeUtils.millis() > timeLastShag + timeIntervalShaga) {
                faza++;
                timeLastShag = TimeUtils.millis();
                if (faza == nFaz + 1) faza = 0;
            }
        }
        if(stateO == STAYO) {
            faza = 0;
        }

        if(x<width/2){
            x = width/2;
            speed = 0;
            stateO = STAYO;
        } else if (x > SCR_WIDTH - width/2) {
            x = SCR_WIDTH - width/2;
            speed = 0;
            stateO = STAYO;
        }
    }


    public void goToO(float tx) {
        target = tx;
        speed = 11;
        stateO = GOO;
        if(tx > x) {
            directO = RIGHTO;
        } else {
            directO = LEFTO;
        }
    }

    float getX() {
        return x-width/2;
    }

    boolean flip() {
        if(directO == LEFTO){
            return true;
        } else {
            return false;
        }
    }

}
