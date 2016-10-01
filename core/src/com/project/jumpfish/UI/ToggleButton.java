package com.project.jumpfish.UI;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Fred on 03/08/2015.
 */
public class ToggleButton {

    private float x,y,width,height;

    private TextureRegion buttonUp;
    private TextureRegion buttonDown;

    private Rectangle bounds;

    private boolean isPressed = false;

    public ToggleButton(float x, float y, float width, float height, TextureRegion buttonUp, TextureRegion buttonDown) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.buttonUp = buttonUp;
        this.buttonDown = buttonDown;

        bounds = new Rectangle(x, y, width, height);
    }

    public void draw(SpriteBatch batcher){
        if(isPressed){
            batcher.draw(buttonDown,x,y,width,height);
        }
        else {
            batcher.draw(buttonUp,x,y,width,height);
        }
    }

    public void toggle(int screenX, int screenY){
        if(bounds.contains(screenX,screenY)){
            if(isPressed){
                isPressed = false;
            }
            else
                isPressed = true;
        }
    }
    public void setPressed(){
        isPressed = true;
    }

    public boolean isPressed(){
        return isPressed;
    }

}
