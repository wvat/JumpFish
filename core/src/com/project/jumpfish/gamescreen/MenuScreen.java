package com.project.jumpfish.gamescreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.menuworld.MenuRenderer;
import com.project.jumpfish.menuworld.MenuWorld;

/**
 * Created by Fred on 10/07/2015.
 */
public class MenuScreen implements Screen {
    private MenuRenderer menuRenderer;
    private MenuWorld menuWorld;
    private MGame game;
    private float runTime;


    public MenuScreen(MGame game){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float menuWidth = 136;
        float menuHeight = screenHeight/(screenWidth/menuWidth);
        int midPointY = (int)menuHeight/2;

        menuWorld = new MenuWorld(midPointY,menuWidth,menuHeight);
        Gdx.input.setInputProcessor(new com.project.jumpfish.gamehelpers.InputHandlerMenu(screenWidth/menuWidth,screenHeight/menuHeight,game,menuWorld));
        menuRenderer = new MenuRenderer(midPointY,menuWidth,menuHeight,menuWorld,game);

        Gdx.app.log("IAB","Premium t/f: " + game.getActionResolver().getPremiumInfo());

    }


    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        runTime += delta;
        menuWorld.update(delta);
        menuRenderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
