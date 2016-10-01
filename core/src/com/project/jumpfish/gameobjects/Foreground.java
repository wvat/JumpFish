package com.project.jumpfish.gameobjects;

/**
 * Created by Fred on 07/07/2015.
 */
public class Foreground extends Scrollable {

    public Foreground(float x, float y, int width, int height, float speed){
        super(x,y,width,height,speed);
    }

    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }
}
