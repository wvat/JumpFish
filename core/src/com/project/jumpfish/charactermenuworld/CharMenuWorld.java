package com.project.jumpfish.charactermenuworld;

import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.menuobjects.MenuScrollHandler;

/**
 * Created by Fred on 03/08/2015.
 */
public class CharMenuWorld {

    private SimpleButton unlockButton, arrowLeftBtn, arrowRightBtn, doneBtn;
    private MenuScrollHandler menuScrollHandler;
    private int midPointY;

    public CharMenuWorld(int midPointY,float menuWidth,float menuHeight){
        unlockButton = new SimpleButton(menuWidth/2 - 19.5f,menuHeight*(4f/5f),39,10, com.project.jumpfish.gamehelpers.AssetLoader.unlockButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.unlockButtonDown);
        arrowLeftBtn = new SimpleButton(menuWidth/2 - 30.5f,menuHeight*(4f/5f),10,10, com.project.jumpfish.gamehelpers.AssetLoader.arrowLeftUp, com.project.jumpfish.gamehelpers.AssetLoader.arrowLeftDown);
        arrowRightBtn = new SimpleButton(menuWidth/2 + 20.5f,menuHeight*(4f/5f),10,10, com.project.jumpfish.gamehelpers.AssetLoader.arrowRightUp, com.project.jumpfish.gamehelpers.AssetLoader.arrowRightDown);
        doneBtn = new SimpleButton(menuWidth - 16, menuHeight - 19,14,18, com.project.jumpfish.gamehelpers.AssetLoader.doneButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.doneButtonDown);

        this.midPointY = midPointY;

        menuScrollHandler = new MenuScrollHandler((float)midPointY);
    }

    public void update(float delta){
        menuScrollHandler.update(delta);
    }


    public SimpleButton getUnlockButton() {
        return unlockButton;
    }

    public SimpleButton getArrowLeftBtn() {
        return arrowLeftBtn;
    }

    public SimpleButton getArrowRightBtn() {
        return arrowRightBtn;
    }

    public SimpleButton getDoneBtn() {
        return doneBtn;
    }

    public int getMidPointY() {
        return midPointY;
    }

    public MenuScrollHandler getMenuScrollHandler() {
        return menuScrollHandler;
    }
}
