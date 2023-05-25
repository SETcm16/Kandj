package com.mygdx.game;

import static com.mygdx.game.KiSH.SCR_HEIGHT;
import static com.mygdx.game.KiSH.SCR_WIDTH;

import com.badlogic.gdx.math.MathUtils;


public class Kamen extends Kamni{
    public Kamen(){
        super(0, 0, 100, 100);
        x = MathUtils.random(width/2, SCR_WIDTH - width/2);
        y = MathUtils.random(SCR_HEIGHT + height/2, SCR_HEIGHT*2);
        vy = MathUtils.random(-15, -10);
    }
}
