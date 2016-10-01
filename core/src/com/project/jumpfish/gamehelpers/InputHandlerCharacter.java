package com.project.jumpfish.gamehelpers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.InputProcessor;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamescreen.MenuScreen;

/**
 * Created by Fred on 03/08/2015.
 */
public class InputHandlerCharacter implements InputProcessor {

    private SimpleButton unlockButton,arrowLeftBtn,arrowRightBtn,doneButton;

    private float scaleFactorX;
    private float scaleFactorY;
    private MGame game;
    private com.project.jumpfish.charactermenuworld.CharMenuWorld charMenuWorld;


    public InputHandlerCharacter(float scaleX,float scaleY,MGame game, com.project.jumpfish.charactermenuworld.CharMenuWorld charMenuWorld){
        scaleFactorX = scaleX;
        scaleFactorY = scaleY;

        this.game = game;
        this.charMenuWorld = charMenuWorld;

        unlockButton = charMenuWorld.getUnlockButton();
        arrowLeftBtn = charMenuWorld.getArrowLeftBtn();
        arrowRightBtn = charMenuWorld.getArrowRightBtn();
        doneButton = charMenuWorld.getDoneBtn();
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

        unlockButton.isTouchDown(screenX,screenY);
        arrowLeftBtn.isTouchDown(screenX,screenY);
        arrowRightBtn.isTouchDown(screenX,screenY);
        doneButton.isTouchDown(screenX,screenY);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        screenX = scaleX(screenX);
        screenY = scaleY(screenY);


        if(unlockButton.isTouchUp(screenX,screenY) && !AssetLoader.isUnlocked(AssetLoader.getCharacterSelector())){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.unlock.play();
            }
            if((AssetLoader.getCharacterPrice(AssetLoader.getCharacterSelector()) == AssetLoader.RUNNER_COST) && (AssetLoader.canPurchase(AssetLoader.RUNNER_COST))) { //A runner is being purchased....
                AssetLoader.unlockCharacter(AssetLoader.getCharacterSelector());
            }
            else if(!game.getActionResolver().getPremiumInfo()) {
                game.getActionResolver().buyPremium();
            }

        }

        if(arrowLeftBtn.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.click.play();
            }
            AssetLoader.deincrementSelector();
        }
        if(arrowRightBtn.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
            AssetLoader.click.play();
            }
            AssetLoader.incrementSelector();
        }
        if(doneButton.isTouchUp(screenX,screenY)){
            if(!AssetLoader.getMuteState()) {
                AssetLoader.click.play();
            }
            if(AssetLoader.isUnlocked(AssetLoader.getCharacterSelector())) {
                AssetLoader.setCharacter(AssetLoader.getCharacterSelector());
                game.setScreen(new com.project.jumpfish.gamescreen.MenuScreen(game));
            }
            else{
                AssetLoader.setCharacterSelector(AssetLoader.getCharacter());
                game.setScreen(new MenuScreen(game));
            }
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

    public SimpleButton getUnlockButton() {
        return unlockButton;
    }

    public SimpleButton getArrowLeftBtn() {
        return arrowLeftBtn;
    }

    public SimpleButton getArrowRightBtn() {
        return arrowRightBtn;
    }

    public SimpleButton getDoneButton() {
        return doneButton;
    }
}
