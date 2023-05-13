package com.mygdx.game;


import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.TimeUtils;

public class Brod {
    float x, y;
    float width, height;
    float speed;
    public static final int RIGHT = 1, LEFT = -1;
    public float direct = RIGHT; // -1 или 1
    public static final int STAY = 0, GO = 1;
    public int state = STAY;
    int faza = 1, nFaz = 4;
    float target;
    long timeLastShag, timeIntervalShaga = 100;

    public Brod(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void move() {

        if (state == GO) {
            x += direct * speed;
            if (direct == RIGHT && x > target || direct == LEFT && x < target) {
                speed = 0;
                x = target;
                state = STAY;
            }
            if (TimeUtils.millis() > timeLastShag + timeIntervalShaga) {
                faza++;
                timeLastShag = TimeUtils.millis();
                if (faza == nFaz + 1) faza = 1;
            }


        }
        if (state == STAY) {
            faza = 0;
        }

        if (x < width / 2) {
            x = width / 2;
            speed = 0;
            state = STAY;
        } else if (x > SCR_WIDTH - width / 2) {
            x = SCR_WIDTH - width / 2;
            speed = 0;
            state = STAY;
        }
    }


    public void goTo(float tx) {
        target = tx;
        speed = 7;
        state = GO;
        if (tx > x) {
            direct = RIGHT;
        } else {
            direct = LEFT;
        }
    }

    float getX() {
        return x - width / 2;
    }

    boolean flip() {
        if (direct == LEFT) {
            return true;
        } else {
            return false;
        }
    }

    boolean overlap(Kamen kamen){
        return kamen.getX() < x - width/4 && x + width/4 < kamen.getX()+ kamen.width && kamen.getY() < y+height && y < kamen.getY() + kamen.height;
    }
}

