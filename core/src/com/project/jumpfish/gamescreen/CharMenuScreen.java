package com.project.jumpfish.gamescreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.project.jumpfish.charactermenuworld.CharMenuRenderer;
import com.project.jumpfish.charactermenuworld.CharMenuWorld;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamehelpers.InputHandlerCharacter;

/**
 * Created by Fred on 03/08/2015.
 */
public class CharMenuScreen implements Screen {

    private CharMenuWorld charMenuWorld;
    private CharMenuRenderer charMenuRenderer;

    private float runTime;


    public CharMenuScreen(MGame game){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float menuWidth = 136;
        float menuHeight = screenHeight/(screenWidth/menuWidth);
        int midPointY = (int)menuHeight/2;

        charMenuWorld = new CharMenuWorld(midPointY,menuWidth,menuHeight);
        Gdx.input.setInputProcessor(new InputHandlerCharacter(screenWidth/menuWidth,screenHeight/menuHeight,game,charMenuWorld));
        charMenuRenderer = new CharMenuRenderer(midPointY,menuWidth,menuHeight,charMenuWorld);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        runTime += delta;
        charMenuWorld.update(delta);
        charMenuRenderer.render();
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
