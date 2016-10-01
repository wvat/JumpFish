package com.project.jumpfish.gameobjects;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Fred on 11/07/2015.
 */
public class Water extends Scrollable {

    private Rectangle waterHitbox;
    public Water(float x, float y, int width, int height, int speed){
        super(x,y,width,height,speed);
        waterHitbox = new Rectangle(x,y + 13,width,height);
    }

    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }

    public Rectangle getWaterHitbox() {
        return waterHitbox;
    }
}
