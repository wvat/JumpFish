package com.project.jumpfish.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

/**
 * Created by Fred on 08/07/2015.
 */
public class Platform extends Scrollable {

    private com.badlogic.gdx.math.Rectangle platformBox;
    private com.badlogic.gdx.math.Rectangle platformContainsBox;

    private Random random;



    public Platform(float x, float y, int width, int height,float speed){
        super(x,y,width,height,speed);
        platformBox = new com.badlogic.gdx.math.Rectangle(x,y,width,height);
        platformContainsBox = new com.badlogic.gdx.math.Rectangle(x-10,0,width+20,y);
        random = new Random();
    }



    @Override
    public void update(float delta) {
        super.update(delta);
        platformBox.set(position.x, position.y, width, height);
        platformContainsBox.set(position.x -10,0,width + 20,position.y);

    }

    public com.badlogic.gdx.math.Rectangle getPlatformBox() {
        return platformBox;
    }

    public void reset(float newX,int gap) {
        width = random.nextInt(40) + 6;
        gap = random.nextInt(5) + gap;
        super.reset(newX + gap);
    }


    public void onRestart(float x, float scrollSpeed,int gap) {
        velocity.x = scrollSpeed;
        reset(x + gap);
    }

    //Getters and Setters
    public void setPlatformWidth(int width){
        this.width = width;
    }


    public com.badlogic.gdx.math.Rectangle getPlatformContainsBox() {
        return platformContainsBox;
    }


}//end Platform
