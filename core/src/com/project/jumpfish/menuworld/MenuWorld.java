package com.project.jumpfish.menuworld;

import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.gamehelpers.AssetLoader;
import com.project.jumpfish.menuobjects.MenuScrollHandler;

/**
 * Created by Fred on 17/07/2015.
 */
public class MenuWorld {

    private SimpleButton playButton;
    private SimpleButton rateButton;
    private com.project.jumpfish.UI.ToggleButton muteButton;
    private SimpleButton charactersButton;
    private SimpleButton premiumButton;
    private SimpleButton noAdsButton;

    private MenuScrollHandler menuScrollHandler;
    private int midpointY;

    public MenuWorld(int midPointY,float menuWidth,float menuHeight){
        this.midpointY = midPointY;

        playButton = new SimpleButton(menuWidth/2 - 20,menuHeight - 28,41,20, com.project.jumpfish.gamehelpers.AssetLoader.playButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.playButtonDown);
        rateButton = new SimpleButton(3,menuHeight - 29 ,18,9, com.project.jumpfish.gamehelpers.AssetLoader.rateButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.rateButtonDown);
        muteButton = new com.project.jumpfish.UI.ToggleButton(3,menuHeight - 16, 14,13f, com.project.jumpfish.gamehelpers.AssetLoader.muteButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.muteButtonDown);
        charactersButton = new SimpleButton(menuWidth/2 + 22 , menuHeight - 23 + 2,44,16, com.project.jumpfish.gamehelpers.AssetLoader.characterButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.characterButtonDown);
        premiumButton = new SimpleButton(menuWidth/2 - 20,menuHeight/2- 7 ,41.25f,8.25f, AssetLoader.bigBuyButtonUp, AssetLoader.bigBuyButtonDown);
        noAdsButton = new SimpleButton(3,menuHeight - 45,12,12,AssetLoader.noAdsButtonUp,AssetLoader.noAdsButtonDown);


        menuScrollHandler = new MenuScrollHandler((float)midPointY);
    }
    public void update(float delta){
        menuScrollHandler.update(delta);
        if(com.project.jumpfish.gamehelpers.AssetLoader.getMuteState()){
            muteButton.setPressed();
        }
    }


    public SimpleButton getPlayButton() {
        return playButton;
    }

    public SimpleButton getRateButton() {
        return rateButton;
    }

    public com.project.jumpfish.UI.ToggleButton getMuteButton() {
        return muteButton;
    }

    public SimpleButton getCharactersButton() {
        return charactersButton;
    }

    public SimpleButton getPremiumButton() {
        return premiumButton;
    }

    public SimpleButton getNoAdsButton() {
        return noAdsButton;
    }

    public MenuScrollHandler getMenuScrollHandler() {
        return menuScrollHandler;
    }

    public int getMidpointY() {
        return midpointY;
    }


}
