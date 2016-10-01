package com.project.jumpfish.menuobjects;

import com.project.jumpfish.gameobjects.Water;

import java.util.Random;

/**
 * Created by Fred on 31/07/2015.
 */
public class MenuScrollHandler {
    private final int WATERSPEED = -15;
    private final int CLOUDSPEED = -10;
    private Water water1,water2;
    private com.project.jumpfish.gameobjects.Cloud cloud1,cloud2,cloud3;

    private Random cloudHeight;
    public MenuScrollHandler(float midPointY) {
        cloudHeight = new Random();
        water1 = new Water(0,midPointY+20,150,30,WATERSPEED);
        water2 = new Water(water1.getTailX(),midPointY+20,150,30,WATERSPEED);

        cloud1 = new com.project.jumpfish.gameobjects.Cloud(0,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);
        cloud2 = new com.project.jumpfish.gameobjects.Cloud(cloud1.getTailX() + 15,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);
        cloud3 = new com.project.jumpfish.gameobjects.Cloud(cloud2.getTailX() + 20,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);
    }

    public void update(float delta) {
        water1.update(delta);
        water2.update(delta);
        cloud1.update(delta);
        cloud2.update(delta);
        cloud3.update(delta);

        if(water1.isScrolledLeft()){
            water1.reset(water2.getTailX());
        }
        else if(water2.isScrolledLeft()){
            water2.reset(water1.getTailX());
        }

        if(cloud1.isScrolledLeft()){
            cloud1.reset(cloud3.getTailX());
        }
        else if(cloud2.isScrolledLeft()){
            cloud2.reset(cloud1.getTailX());
        }
        else if(cloud3.isScrolledLeft()){
            cloud3.reset(cloud2.getTailX());
        }

    }

    public Water getWater1() {
        return water1;
    }

    public Water getWater2() {
        return water2;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud1() {
        return cloud1;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud2() {
        return cloud2;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud3() {
        return cloud3;
    }
}
