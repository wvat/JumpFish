package com.project.jumpfish.gameobjects;

/**
 * Created by Fred on 10/07/2015.
 */
public class Dirt extends Scrollable {
    public Dirt(float x, float y, int width, int height, int speed){
        super(x,y,width,height,speed);
    }
    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }


}
