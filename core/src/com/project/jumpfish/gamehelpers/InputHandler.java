package com.project.jumpfish.gamehelpers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamescreen.MenuScreen;
import com.project.jumpfish.gameworld.GameWorld;

/**
 * Created by Fred on 03/07/2015.
 */

public class InputHandler implements InputProcessor{
    private MGame game;
    private SimpleButton menuButton,okButton,buyButton;
    private GameWorld gameWorld;
    private float scaleFactorX, scaleFactorY;
    public InputHandler(GameWorld gameWorld,float scaleFactorX, float scaleFactorY, MGame game){
        this.gameWorld = gameWorld;
        this.scaleFactorX = scaleFactorX;
        this.scaleFactorY = scaleFactorY;
        this.game = game;
        menuButton = gameWorld.getReturnToMenu();
        okButton = gameWorld.getOkButton();
        buyButton = gameWorld.getBuyButton();
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

        if(gameWorld.getCurrentState() == GameWorld.GameState.READY){
            gameWorld.setCurrentState(GameWorld.GameState.RUNNING);
        }

        else if(gameWorld.getCurrentState() == GameWorld.GameState.RUNNING){
            gameWorld.getRunner().onClick();
        }


        menuButton.isTouchDown(screenX,screenY);
        okButton.isTouchDown(screenX,screenY);
        buyButton.isTouchDown(screenX,screenY);

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        screenX = scaleX(screenX);
        screenY = scaleY(screenY);
        if(menuButton.isTouchUp(screenX, screenY)){

            if((gameWorld.getCurrentState() == GameWorld.GameState.GAMEOVER ||
                    gameWorld.getCurrentState() == GameWorld.GameState.HIGHSCORE)) {
                if (!AssetLoader.getMuteState()) {
                    AssetLoader.click.play();
                }
                game.setScreen(new MenuScreen(game));
            }
        }
        if(okButton.isTouchUp(screenX,screenY)){
            if((gameWorld.getCurrentState() == GameWorld.GameState.GAMEOVER ||
                    gameWorld.getCurrentState() == GameWorld.GameState.HIGHSCORE)&&
                    !menuButton.isTouchDown(screenX,screenY)){
                if(!AssetLoader.getMuteState()) {
                    AssetLoader.click.play();
                }

                gameWorld.restart();
            }
        }

        if(buyButton.isTouchUp(screenX,screenY) && !game.getActionResolver().getPremiumInfo()){
            if((gameWorld.getCurrentState() == GameWorld.GameState.GAMEOVER ||
                    gameWorld.getCurrentState() == GameWorld.GameState.HIGHSCORE)) {
                if (!AssetLoader.getMuteState()) {
                    AssetLoader.click.play();
                }
                game.getActionResolver().buyPremium();
            }
        }

        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        Gdx.app.log("Dragged","dragged");
     /*   if(gameWorld.getCurrentState() == GameWorld.GameState.RUNNING){
            gameWorld.getRunner().Jab();
        }*/

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


}
