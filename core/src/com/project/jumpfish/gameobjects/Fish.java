package com.project.jumpfish.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Fred on 11/07/2015.
 */
public class Fish {

    private Vector2 velocity;
    private Vector2 position;
    private Vector2 acceleration;

    private Rectangle boundingRectangle;

    private int width,height;
    private float rotation;

    private boolean caught = false;

    private Random random;

    private int value = 1;



    public Fish(float x, float y, int width, int height,float direction){
        random = new Random();
        position = new Vector2(x,y);
        velocity = new Vector2(direction,-(random.nextInt(50) + 100));
        acceleration = new Vector2(0,150);

        this.width = width;
        this. height = height;
        boundingRectangle = new Rectangle(x,y,width,height);
    }

    public void update(float delta){
        velocity.add(acceleration.cpy().scl(delta));
        position.add(velocity.cpy().scl(delta));
        if(velocity.y < 0){
            rotation = 45;
        }
        else if(velocity.y > 0){
            rotation = -45;
        }
        boundingRectangle.set(position.x,position.y,width,height);

    }

    public boolean isVisible(){
        if(position.x + width < 0 || position.y > 400 || position.y <  - 100){
            return false;
        }
        else {
            return true;
        }
    }

    public void reset(float newX){
        position.x = newX;
    }

    public void onRestart(float newX, int speed){

    }

    public void hasBeenCaught(){
        caught = true;
    }

    //******GETTERS AND SETTERS*****


    public boolean isCaught() {
        return caught;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public float getRotation() {
        return rotation;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public float getY(){
        return position.y;
    }

    public float getX(){
        return position.x;
    }

    public float getVx(){
        return velocity.x;
    }

    public Rectangle getBoundingRectangle() {
        return boundingRectangle;
    }

    public int getValue() {
        return value;
    }
}
