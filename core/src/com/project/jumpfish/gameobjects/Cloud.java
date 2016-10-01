package com.project.jumpfish.gameobjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

/**
 * Created by Fred on 17/07/2015.
 */
public class Cloud extends Scrollable{


    private TextureRegion cloud;
    private Random random;
    private float x,y;
    private int width,height,speed;
    private int GAP;

    public Cloud(float x, float y, int width, int height, int speed){
        super(x,y,width,height,speed);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;

        random = new Random();
        setCloudTexture();
    }
    public void onRestart(float newX,int newSpeed){
        velocity.x = newSpeed;
        setCloudTexture();
        reset(newX);
    }
    public void reset(float newX){
        GAP = random.nextInt(20) + 10;
        position.y = random.nextInt(10) + 5;
        super.reset(newX + GAP);
    }


    public void setCloudTexture(){
        switch (random.nextInt(3)){
            case 0:
                cloud = com.project.jumpfish.gamehelpers.AssetLoader.cloud1;
                break;
            case 1:
                cloud = com.project.jumpfish.gamehelpers.AssetLoader.cloud2;
                break;
            case 2:
                cloud = com.project.jumpfish.gamehelpers.AssetLoader.cloud3;
                break;
            default:
                cloud = com.project.jumpfish.gamehelpers.AssetLoader.cloud1;
                break;
        }
    }

    public void drawCloud(SpriteBatch batcher){
        batcher.draw(cloud,x,y,width/2,height/2,width,height,1f,1f,0f);
    }

    public TextureRegion getCloud() {
        return cloud;
    }
}
