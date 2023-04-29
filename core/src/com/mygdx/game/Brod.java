package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.utils.TimeUtils;


public class Brod {
    float x, vx;
    float width;

    void vihodZaEkran() {
        if(x<0+width/2) {
            x = 0+width/2;
            vx = 0;
        }
        if(x>SCR_WIDTH-width/2) {
            x = SCR_WIDTH-width/2;
            vx = 0;
        }
    }
}
