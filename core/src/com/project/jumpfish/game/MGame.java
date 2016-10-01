package com.project.jumpfish.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * Created by Fred on 03/07/2015.
 * Description: A simplistic platforming game.
 *
 * Version: v1.0
 * Changelog v1.0 - Initial design.
 *
 */
public class MGame extends Game {
    ActionResolver actionResolver;
    public MGame(ActionResolver actionResolver){
        this.actionResolver = actionResolver;
    }

    @Override
    public void create() {
        Gdx.app.log("MGame", "created");
        com.project.jumpfish.gamehelpers.AssetLoader.load(this);
        setScreen(new com.project.jumpfish.gamescreen.SplashScreen(this));
    }

    @Override
    public void dispose() {
        super.dispose();
        com.project.jumpfish.gamehelpers.AssetLoader.dispose();

    }

    public ActionResolver getActionResolver() {
        return actionResolver;
    }
}
