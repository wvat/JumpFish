package com.project.jumpfish.gamescreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamehelpers.AssetLoader;

/**
 * Created by Fred on 10/07/2015.
 */
public class SplashScreen implements Screen {
    private Long startTime;
    private MGame game;
    private SpriteBatch batcher;
    private OrthographicCamera camera;
    private int midPointX,midPointY;
    private TextureRegion logo,logoGame;

    public SplashScreen(MGame game){

        this.game = game;
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float menuWidth = 136;
        float menuHeight = screenHeight/(screenWidth/menuWidth);

        camera = new OrthographicCamera();
        camera.setToOrtho(true,menuWidth,menuHeight);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);

        midPointY = (int)menuHeight/2;
        midPointX = (int)menuWidth/2;


    }

    @Override
    public void show() {
        logo = com.project.jumpfish.gamehelpers.AssetLoader.goldFish1;
        logoGame = AssetLoader.logo;
        startTime = TimeUtils.millis();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(9/255f, 152/255f, 211/255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batcher.begin();
        batcher.draw(logo, midPointX - 16, midPointY - 20, 16 / 2, 16 / 2, 32, 32, 1.0f, 1.0f, 0f);
        batcher.draw(logoGame, midPointX - 60, midPointY - 10, 125f / 2f, 54f / 2f, 125, 54, 0.45f, 0.45f, 0f);
        batcher.end();

        Gdx.app.log("time", "start time: " + startTime);
        Gdx.app.log("time", "time: " + TimeUtils.millis());
        if(TimeUtils.timeSinceMillis(startTime) > 3000){
            Gdx.app.log("time","time up");
            game.setScreen(new MenuScreen(game));
        }
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
