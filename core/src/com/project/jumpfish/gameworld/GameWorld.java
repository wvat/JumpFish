package com.project.jumpfish.gameworld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.gamehelpers.AssetLoader;
import com.project.jumpfish.gameobjects.Fish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Fred on 03/07/2015.
 */
public class GameWorld {


    private com.badlogic.gdx.math.Rectangle ground;

    GameState currentState;

    private int midPointY, midPointX;
    private int readyflag = 0;
    private int gameOverFlag = 0;

    private boolean fished = true;
    private com.project.jumpfish.gameobjects.Runner runner;
    private com.project.jumpfish.gameobjects.ScrollHandler scrollHandler;
    private ArrayList<Fish> fishs;

    private int score = 0;

    private Random random;

    private float platformYPos;

    private SimpleButton returnToMenu;
    private SimpleButton okButton, buyButton;



    public enum GameState {
        READY, RUNNING,DYING,GAMEOVER,HIGHSCORE
    }


    public GameWorld(int midPointY,int midPointX) {
        platformYPos = 67;
        random = new Random();
        currentState = GameState.READY;
        this.midPointY = midPointY;
        this.midPointX = midPointX;
        ground = new com.badlogic.gdx.math.Rectangle(0,20, 137, 20);
        scrollHandler = new com.project.jumpfish.gameobjects.ScrollHandler(midPointY,this,platformYPos);
        runner = new com.project.jumpfish.gameobjects.Runner(10,platformYPos - 58,64,64,midPointX,this);
        fishs = new ArrayList<Fish>();
        returnToMenu = new SimpleButton(midPointX*2 - 24,midPointY*2 - 9,25,10, com.project.jumpfish.gamehelpers.AssetLoader.menuButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.menuButtonDown);
        okButton = new SimpleButton(midPointX - 16,midPointY * 1.75f,32,9, com.project.jumpfish.gamehelpers.AssetLoader.okButtonUp, com.project.jumpfish.gamehelpers.AssetLoader.okButtonDown);
        buyButton = new SimpleButton(0,midPointY*1.75f,48,9, AssetLoader.smallBuyButtonUp,AssetLoader.smallBuyButtonDown);



    }

    public void update(float delta) {

        switch (currentState) {
            case READY:
                updateReady(delta);
                break;
            case GAMEOVER:
            case DYING:
            case RUNNING:
            default:
                updateRunning(delta);
                break;
        }

    }

    private void updateReady(float delta) {

        Gdx.app.log("Runner Y",runner.getPositionY() + "");

        for (Iterator<Fish> iterator = fishs.iterator(); iterator.hasNext(); ) {
            Fish fish = iterator.next();
            iterator.remove();
        }

        if(runner.getPositionY() != 12.0f){
            runner.setYPos(12.0f);
        }

        if(readyflag == 0){
            runner.setSkin(com.project.jumpfish.gamehelpers.AssetLoader.getCharacter());

            runner.update(delta);
            scrollHandler.update(delta);
            readyflag = 1;
            gameOverFlag = 0;
        }

    }

    public void updateRunning(float delta) {
        if (delta > .15f) {
            delta = .15f;
        }

        Gdx.app.log("Runner Y",runner.getPositionY() + "");


        runner.update(delta);
        scrollHandler.update(delta);

        if(scrollHandler.runnerOverPlatform()){
            if(!fished){
                Fish fish = new Fish(runner.getPositionX() + random.nextInt(10) + 100, 70 ,16,16,-100);
                fishs.add(fish);
                fished = true;
            }
        }
        else{
            fished = false;
        }
        for(Fish f: fishs){
            f.update(delta);
        }


        for (Iterator<Fish> iterator = fishs.iterator(); iterator.hasNext(); ) {
            Fish fish = iterator.next();
            if (!fish.isVisible()) {
                iterator.remove();
            }
        }

        if(!runner.isAlive()){
            scrollHandler.stop();
            currentState = GameState.GAMEOVER;
        }
        if(currentState == GameState.GAMEOVER){
            if(gameOverFlag == 0){
                com.project.jumpfish.gamehelpers.AssetLoader.incrementTotalFish(score);
                gameOverFlag = 1;
            }
        }
        if(score > com.project.jumpfish.gamehelpers.AssetLoader.getHighScore()){
            com.project.jumpfish.gamehelpers.AssetLoader.setHighScore(score);
        }

        Gdx.app.log("highscore", com.project.jumpfish.gamehelpers.AssetLoader.getHighScore() + "");


        readyflag = 0;



    }

    public void restart(){
        currentState = GameState.READY;
        score = 0;
        fished = false;
        scrollHandler.restart();
        runner.restart(10, midPointY / 2 - 5);
        currentState = GameState.READY;
    }

    public void incrementScore(int increment){
        score += increment;
        Gdx.app.log("score",+ score +"");
    }



    //*************GETTERS AND SETTERS**************\\

    public com.project.jumpfish.gameobjects.Runner getRunner() {
        return runner;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public Rectangle getGround() {
        return ground;
    }

    public void setGround(Rectangle ground) {
        this.ground = ground;
    }

    public int getMidPointY() {
        return midPointY;
    }

    public void setMidPointY(int midPointY) {
        this.midPointY = midPointY;
    }

    public com.project.jumpfish.gameobjects.ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<Fish> getFishs() {
        return fishs;
    }

    public void addFish(Fish fish){
        fishs.add(fish);
    }

    public SimpleButton getReturnToMenu() {
        return returnToMenu;
    }

    public SimpleButton getOkButton() {
        return okButton;
    }

    public SimpleButton getBuyButton() {
        return buyButton;
    }
}
