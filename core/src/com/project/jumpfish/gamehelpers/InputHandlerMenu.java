package com.project.jumpfish.gamehelpers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.UI.ToggleButton;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamescreen.CharMenuScreen;
import com.project.jumpfish.gamescreen.GameScreen;
import com.project.jumpfish.menuworld.MenuWorld;

/**
 * Created by Fred on 12/07/2015.
 */


public class InputHandlerMenu implements InputProcessor{

    private SimpleButton playButton,characterButton,rateButton,premiumButton,noAdsButton;
    private ToggleButton muteButton;

    private float scaleFactorX;
    private float scaleFactorY;
    private MGame game;
    private MenuWorld menuWorld;


    public InputHandlerMenu(float scaleX,float scaleY,MGame game,MenuWorld menuWorld){
        scaleFactorX = scaleX;
        scaleFactorY = scaleY;

        this.game = game;
        this.menuWorld = menuWorld;

        playButton = menuWorld.getPlayButton();
        characterButton = menuWorld.getCharactersButton();
        muteButton = menuWorld.getMuteButton();
        rateButton = menuWorld.getRateButton();
        premiumButton = menuWorld.getPremiumButton();
        noAdsButton = menuWorld.getNoAdsButton();

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        playButton.isTouchDown(screenX, screenY);
        characterButton.isTouchDown(screenX,screenY);
        rateButton.isTouchDown(screenX,screenY);
        premiumButton.isTouchDown(screenX,screenY);
        noAdsButton.isTouchDown(screenX,screenY);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);

        if(noAdsButton.isTouchUp(screenX,screenY)  && !game.getActionResolver().getPremiumInfo()){
            if(!AssetLoader.getMuteState()){
                AssetLoader.click.play();
            }
            game.getActionResolver().buyPremium();
        }


        if(playButton.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.click.play();
            }
            if(AssetLoader.isUnlocked(AssetLoader.getCharacterSelector())) {
                game.setScreen(new GameScreen(game));
            }
            AssetLoader.setCharacter(AssetLoader.getCharacterSelector());
        }

        if(characterButton.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.click.play();
            }
            game.setScreen(new CharMenuScreen(game));
        }

        if(rateButton.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.click.play();
            }
            game.getActionResolver().rate();
        }

        muteButton.toggle(screenX,screenY);
        if(muteButton.isPressed()){
            AssetLoader.muteSound(true);
        }
        else{
            AssetLoader.muteSound(false);
        }
        if(premiumButton.isTouchUp(screenX,screenY) && !game.getActionResolver().getPremiumInfo()){
            if(!AssetLoader.getMuteState()){
                AssetLoader.click.play();
            }
            game.getActionResolver().buyPremium();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public int scaleX(int screenX){
        return (int)(screenX/scaleFactorX);
    }

    public int scaleY(int screenY){
        return (int)(screenY/scaleFactorY);
    }

    public SimpleButton getPlayButton(){
        return playButton;
    }
}
