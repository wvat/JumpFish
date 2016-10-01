package com.project.jumpfish.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.project.jumpfish.gamehelpers.AssetLoader;
import com.project.jumpfish.gameworld.GameWorld;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Fred on 04/07/2015.
 */
public class Runner {

    private Vector2 velocity;
    private Vector2 acceleration;
    private Vector2 position;
    private boolean jumping = false;
    private Random random;
    private int midPointX,width,height;
    private GameWorld world;
    private Platform platform1,platform2,platform3;
    private Rectangle hitBoxFeet,hitBoxBody;
    private Rectangle platform1HB,platform2HB,platform3HB;
    private static final int offSetX = 25;
    private static final int offSetY = 40;
    private static final int offsetWidth = -55;
    private static final int offSetHeight = -55;
    private int skin = 0;
    private boolean alive;
    private float yPos;
    private Animation runnerAnimation;
    private TextureRegion runnerJump,runnerIdle;


    public Runner(float x, float y, int width, int height, int midPointX, GameWorld world){

        position = new Vector2(x,y);//set initial position
        velocity = new Vector2(20,0);//set initial velocity
        acceleration = new Vector2(0,490);//set initial acceleration

        alive = true;//Runner starts off alive.

        this.width = width;//width of the character
        this.height = height;//height of the character
        this.midPointX = midPointX;
        this.world = world;

        yPos = y;

        hitBoxFeet = new Rectangle(position.x+offSetX,position.y + offSetY,width + offsetWidth,height+offSetHeight);
        hitBoxBody = new Rectangle(position.x-offSetX/2,position.y,width - 50,height- 25);


        random = new Random();

    }

    public void update(float delta) {

        if (world.getCurrentState() == GameWorld.GameState.GAMEOVER) {
            if (!jumping) {
                acceleration.y = 200;
            }
            velocity.add(acceleration.cpy().scl(delta));
            position.add(velocity.cpy().scl(delta));
            if (position.x > midPointX - 25) {
                position.x = midPointX - 25;
            }
        }
            if ((world.getCurrentState() == GameWorld.GameState.RUNNING)) {
                if (!jumping) {
                    acceleration.y = 200;
                } else {
                    acceleration.y = 490;
                }
                velocity.add(acceleration.cpy().scl(delta));
                position.add(velocity.cpy().scl(delta));
                if (position.x > midPointX - 25) {
                    position.x = midPointX - 25;
                }
                catchFish(world.getFishs());
                platformCollision(world.getScrollHandler());

                if(alive && (hitBoxFeet.overlaps(world.getScrollHandler().getWater1().getWaterHitbox()))) {
                    if(!AssetLoader.getMuteState())
                        AssetLoader.splash.play();
                    alive = false;
                }

            }

            hitBoxFeet.set(position.x + offSetX, position.y + offSetY, width + offsetWidth, height + offSetHeight);
            hitBoxBody.set(position.x + offSetX,position.y + 15,width - 50,height- 30);
        }

    public void jump(){
        if(!jumping && world.getScrollHandler().runnerOverPlatform()) {
            velocity.y = -200;
            jumping = true;
            if(!com.project.jumpfish.gamehelpers.AssetLoader.getMuteState()) {
                com.project.jumpfish.gamehelpers.AssetLoader.jump.play();
            }
        }
    }

    public void catchFish(ArrayList<Fish> fishs){
        for (Iterator<Fish> iterator = fishs.iterator(); iterator.hasNext(); ) {
            Fish fish = iterator.next();
            if(hitBoxBody.overlaps(fish.getBoundingRectangle())) {
                if(!com.project.jumpfish.gamehelpers.AssetLoader.getMuteState()) {
                    com.project.jumpfish.gamehelpers.AssetLoader.jump.stop();
                    com.project.jumpfish.gamehelpers.AssetLoader.catchFish.play();
                }
                iterator.remove();
                world.incrementScore(fish.getValue());
            }
        }
    }

    public void platformCollision(ScrollHandler scrollHandler){
        platform1 = scrollHandler.getPlatform1();
        platform2 = scrollHandler.getPlatform2();
        platform3 = scrollHandler.getPlatform3();

        platform1HB = platform1.getPlatformBox();
        platform2HB = platform2.getPlatformBox();
        platform3HB = platform3.getPlatformBox();

        Gdx.app.log("contains", scrollHandler.runnerOverPlatform() + "");

        if(scrollHandler.runnerOverPlatform()){
            if(!jumping){
                position.y = yPos+3;
            }
            if(jumping && position.y >= yPos+3){
                jumping = false;
                position.y = yPos+3;
            }

        }

    }

    public void onClick(){
        jump();
    }

    public void restart(int xPos, int yPos){
        position.x = xPos;
        position.y = yPos;
        velocity.x = 20;
        velocity.y = 0;
        acceleration.x = 0;
        acceleration.y = 490;
        jumping = false;
        alive = true;
    }

    public void setSkin(int skin){
     //   skin = random.nextInt(2);
        Gdx.app.log("Skin", skin + "");
        switch(skin){
            case 0:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1Anim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1Idle;
                break;
            case 1:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Anim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle;
                break;
            case 2:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3Anim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3Idle;
                break;
            case 3:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor4Anim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor4Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor4Idle;
                break;
            case 4:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1WraithAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor1Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor1Idle;
                break;

            case 5:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2WraithAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor2Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor2Idle;
                break;

            case 6:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3WraithAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor3Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.wraithColor3Idle;
                break;

            case 7:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1DiverAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.diverColor1Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.diverColor1Idle;
                break;

            case 8:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2DiverAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.diverColor2Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.diverColor2Idle;
                break;

            case 9:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3DiverAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.diverColor3Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.diverColor3Idle;
                break;

            case 10:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1BearAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.bearColor1Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.bearColor1Idle;
                break;

            case 11:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2BearAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.bearColor2Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.bearColor2Idle;
                break;

            case 12:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3BearAnim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.bearColor3Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.bearColor3Idle;
                break;

            default:
                runnerAnimation = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Anim;
                runnerJump = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Jump;
                runnerIdle = com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle;
                break;
        }
    }


    //*************GETTERS AND SETTERS**************\\


    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(Vector2 acceleration) {
        this.acceleration = acceleration;
    }

    public float getPositionX() {
        return position.x;
    }
    public float getPositionY() {
        return position.y;
    }

    public void setYPos(float yPos){
        position.y = yPos;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getHitBox() {
        return hitBoxFeet;
    }

    public boolean isAlive() {
        return alive;
    }


    public Rectangle getHitBoxBody() {
        return hitBoxBody;
    }

    public int getSkin() {
        return skin;
    }

    public Animation getRunnerAnimation() {
        return runnerAnimation;
    }

    public TextureRegion getRunnerJump() {
        return runnerJump;
    }

    public TextureRegion getRunnerIdle() {
        return runnerIdle;
    }
}
