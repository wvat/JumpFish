package com.project.jumpfish.gameobjects;

import com.project.jumpfish.gameworld.GameWorld;

import java.util.Random;

/**
 * Created by Fred on 05/07/2015.
 */
public class ScrollHandler {



    private GameWorld gameWorld;
    private Foreground fg1, fg2;
    private com.project.jumpfish.gameobjects.Dirt d1,d2;
    private com.project.jumpfish.gameobjects.Platform platform1,platform2,platform3;
    private com.project.jumpfish.gameobjects.Background bg1,bg2;
    private com.project.jumpfish.gameobjects.Water water1,water2;
    private com.project.jumpfish.gameobjects.Cloud cloud1,cloud2,cloud3;

    private static final int WATERSPEED = -100 ;
    private static final int SPEED = -125;//-120
    private static final int CLOUDSPEED = -15;
    private static final int GAP = 100;//95

    private Random cloudHeight;
    private Random random;

    private float platformYPos;

    public ScrollHandler (float yPos, GameWorld gameWorld,float platformYPos){
        this.gameWorld = gameWorld;
        this.platformYPos = platformYPos;

        cloudHeight = new Random();
        random = new Random();

        fg1 = new Foreground(0,-50,256,128,SPEED);
        fg2 = new Foreground(fg1.getTailX(),-50,256,128,SPEED);

        d1 = new com.project.jumpfish.gameobjects.Dirt(0,fg1.getY() + fg2.getHeight(),150,30,SPEED);
        d2 = new com.project.jumpfish.gameobjects.Dirt(d1.getTailX(),fg2.getY() + fg2.getHeight(),150,30,SPEED);

        bg1 = new com.project.jumpfish.gameobjects.Background(0,-30,256,128,-10);
        bg2 = new com.project.jumpfish.gameobjects.Background(bg1.getTailX(),-30,256,128,-10);

        water1 = new com.project.jumpfish.gameobjects.Water(0,yPos+20,150,30,WATERSPEED);
        water2 = new com.project.jumpfish.gameobjects.Water(water1.getTailX(),yPos+20,150,30,WATERSPEED);

        platform1 = new com.project.jumpfish.gameobjects.Platform(-10,platformYPos,120,40,SPEED); //75,40
        platform2 = new com.project.jumpfish.gameobjects.Platform(platform1.getTailX() + random.nextInt(5) + GAP,platformYPos,random.nextInt(40) + 6,40,SPEED);//75,40
        platform3 = new com.project.jumpfish.gameobjects.Platform(platform2.getTailX() + random.nextInt(5) + GAP,platformYPos,random.nextInt(40) + 6,40,SPEED);//75,40

        cloud1 = new com.project.jumpfish.gameobjects.Cloud(0,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);
        cloud2 = new com.project.jumpfish.gameobjects.Cloud(cloud1.getTailX() + 15,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);
        cloud3 = new com.project.jumpfish.gameobjects.Cloud(cloud2.getTailX() + 20,cloudHeight.nextInt(10) + 5,64,32,CLOUDSPEED);

    }
    public void update(float delta) {
        fg1.update(delta);
        fg2.update(delta);

        bg1.update(delta);
        bg2.update(delta);

        water1.update(delta);
        water2.update(delta);

        platform1.update(delta);
        platform2.update(delta);
        platform3.update(delta);

        cloud1.update(delta);
        cloud2.update(delta);
        cloud3.update(delta);

        if(water1.isScrolledLeft){
            water1.reset(water2.getTailX());
        }
        else if(water2.isScrolledLeft){
            water2.reset(water1.getTailX());
        }

        if(bg1.isScrolledLeft){
            bg1.reset(bg2.getTailX());
        }
        else if(bg2.isScrolledLeft){
            bg2.reset(bg1.getTailX());
        }

        if(fg1.isScrolledLeft){
            fg1.reset(fg2.getTailX());
        }
        else if(fg2.isScrolledLeft){
            fg2.reset(fg1.getTailX());
        }

        if(d1.isScrolledLeft){
            d1.reset(d2.getTailX());
        }
        else if(d2.isScrolledLeft){
            d2.reset(d1.getTailX());
        }

        if(platform1.isScrolledLeft){
            platform1.reset(platform3.getTailX(),GAP);
        }
        else if(platform2.isScrolledLeft){
            platform2.reset(platform1.getTailX(),GAP);
        }
        else if(platform3.isScrolledLeft){
            platform3.reset(platform2.getTailX(),GAP);
        }

        if(cloud1.isScrolledLeft){
            cloud1.reset(cloud3.getTailX());
        }
        else if(cloud2.isScrolledLeft){
            cloud2.reset(cloud1.getTailX());
        }
        else if(cloud3.isScrolledLeft){
            cloud3.reset(cloud2.getTailX());
        }



    }

    public boolean runnerOverPlatform(){
        Runner runner = gameWorld.getRunner();
        if((platform1.getPlatformContainsBox().contains(runner.getHitBox()))|| (platform2.getPlatformContainsBox().contains(runner.getHitBox()))|| (platform3.getPlatformContainsBox().contains(runner.getHitBox()))){
            return true;
        }
        else {
            return false;
        }

    }

    public void stop(){
        bg1.stop();
        bg2.stop();
        fg1.stop();
        fg2.stop();
        d1.stop();
        d2.stop();
        platform1.stop();
        platform2.stop();
        platform3.stop();
    }

    public void restart(){
        fg1.onRestart(0,SPEED);
        fg2.onRestart(fg1.getTailX(),SPEED);

        bg1.onRestart(0,-10);
        bg2.onRestart(bg1.getTailX(),-10);

        d1.onRestart(0, SPEED);
        d2.onRestart(d1.getTailX(),SPEED);

        water1.onRestart(0,WATERSPEED);
        water2.onRestart(water1.getTailX(), WATERSPEED);

        platform1.onRestart(-10, SPEED, 0);
        platform1.setPlatformWidth(120);
        platform2.onRestart(platform1.getTailX(), SPEED, GAP);
        platform3.onRestart(platform2.getTailX(), SPEED, GAP);

        cloud1.onRestart(0,CLOUDSPEED);
        cloud2.onRestart(cloud1.getTailX(),CLOUDSPEED);
        cloud3.onRestart(cloud2.getTailX(), CLOUDSPEED);


    }


    //*************GETTERS AND SETTERS**************\\


    public Foreground getFg1() {
        return fg1;
    }

    public Foreground getFg2() {
        return fg2;
    }

    public com.project.jumpfish.gameobjects.Platform getPlatform1() {
        return platform1;
    }

    public com.project.jumpfish.gameobjects.Platform getPlatform2() {
        return platform2;
    }

    public com.project.jumpfish.gameobjects.Platform getPlatform3() {
        return platform3;
    }

    public com.project.jumpfish.gameobjects.Dirt getD1() {
        return d1;
    }

    public com.project.jumpfish.gameobjects.Dirt getD2() {
        return d2;
    }

    public com.project.jumpfish.gameobjects.Background getBg1() {
        return bg1;
    }

    public com.project.jumpfish.gameobjects.Background getBg2() {
        return bg2;
    }

    public com.project.jumpfish.gameobjects.Water getWater1() {
        return water1;
    }

    public com.project.jumpfish.gameobjects.Water getWater2() {
        return water2;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud1() {
        return cloud1;
    }

    public void setCloud1(com.project.jumpfish.gameobjects.Cloud cloud1) {
        this.cloud1 = cloud1;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud2() {
        return cloud2;
    }

    public void setCloud2(com.project.jumpfish.gameobjects.Cloud cloud2) {
        this.cloud2 = cloud2;
    }

    public com.project.jumpfish.gameobjects.Cloud getCloud3() {
        return cloud3;
    }

    public void setCloud3(com.project.jumpfish.gameobjects.Cloud cloud3) {
        this.cloud3 = cloud3;
    }
}


