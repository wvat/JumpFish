package com.project.jumpfish.gamescreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.project.jumpfish.game.MGame;

/**
 * Created by Fred on 03/07/2015.
 */
public class GameScreen implements Screen{
    private com.project.jumpfish.gameworld.GameWorld gameWorld;
    private com.project.jumpfish.gameworld.GameRenderer gameRenderer;

    private float runTime = 0;
    float screenWidth,screenHeight;

    public GameScreen(MGame game){
        Gdx.app.log("GameScreen","Attached");

        screenWidth = Gdx.graphics.getWidth();
        Gdx.app.log("Screenwidth",+screenWidth+"");

        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);

        int midPointY = (int)(gameHeight/2);
        int midPointX = (int)(gameWidth/2);

        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();


        gameWorld = new com.project.jumpfish.gameworld.GameWorld(midPointY,midPointX);

        gameRenderer = new com.project.jumpfish.gameworld.GameRenderer(gameWorld,midPointY,(int)gameHeight,(int)gameWidth,midPointX,game);

        Gdx.input.setInputProcessor(new com.project.jumpfish.gamehelpers.InputHandler(gameWorld,screenWidth/gameWidth,screenHeight/gameHeight,game));


     /*   float gameHeight = 136;
        float gameWidth = screenWidth/(screenHeight/gameHeight);

        int midPointY = (int)(gameHeight/2);
        int midPointX = (int)(gameWidth/2);

        gameWorld = new GameWorld(midPointY,midPointX);

        gameRenderer = new GameRenderer(gameWorld,midPointY,(int)gameHeight,(int)gameWidth,midPointX);

        Gdx.input.setInputProcessor(new InputHandler(gameWorld)); */


    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen","show called");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        gameWorld.update(delta);
        gameRenderer.render(runTime);
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen","resizing");
    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen","pause called");
    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen","resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen","hide called");
    }

    @Override
    public void dispose() {
    }
    public float getWidth(){
        return screenWidth;
    }

}
