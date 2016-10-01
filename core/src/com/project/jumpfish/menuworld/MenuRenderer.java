package com.project.jumpfish.menuworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.UI.ToggleButton;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamehelpers.AssetLoader;
import com.project.jumpfish.gameobjects.Cloud;
import com.project.jumpfish.gameobjects.Water;

/**
 * Created by Fred on 12/07/2015.
 */
public class MenuRenderer {
    private MenuWorld menuWorld;
    private OrthographicCamera camera;
    private SpriteBatch batcher;

    private SimpleButton playButton,characterButton,rateButton,premiumButton,noAdsButton;
    private ToggleButton muteButton;
    private Water water1,water2;
    private Cloud cloud1,cloud2,cloud3;

    private TextureRegion water,sky,logo,currentCharacterSelected,premiumSign;

    private float width,height;

    private  float XPOS;
    private  float YPOS;
    private  float SCALE = 0.5f;

    private MGame game;
    private boolean isPremium;

    public MenuRenderer(int midPointY,float width, float height,MenuWorld menuWorld,MGame game){
        this.menuWorld = menuWorld;
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(true,width,height);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        this.width = width;
        this.height = height;

        XPOS = width/2 + 13;
        YPOS = height/2 - 31;

        isPremium = game.getActionResolver().getPremiumInfo();



        initObjects();
        initTextures();

    }

    public void initObjects(){
        playButton = menuWorld.getPlayButton();
        characterButton = menuWorld.getCharactersButton();
        rateButton = menuWorld.getRateButton();
        muteButton = menuWorld.getMuteButton();
        premiumButton = menuWorld.getPremiumButton();
        noAdsButton = menuWorld.getNoAdsButton();

        cloud1 = menuWorld.getMenuScrollHandler().getCloud1();
        cloud2 = menuWorld.getMenuScrollHandler().getCloud2();
        cloud3 = menuWorld.getMenuScrollHandler().getCloud3();

        water1 = menuWorld.getMenuScrollHandler().getWater1();
        water2 = menuWorld.getMenuScrollHandler().getWater2();
    }

    public void initTextures(){
        water = com.project.jumpfish.gamehelpers.AssetLoader.water;
        sky = com.project.jumpfish.gamehelpers.AssetLoader.skyBox;
        logo = com.project.jumpfish.gamehelpers.AssetLoader.logo;
        currentCharacterSelected = com.project.jumpfish.gamehelpers.AssetLoader.currentCharacterSign;
        premiumSign = AssetLoader.premiumButtonUp;
    }

    public void drawWater(Batch batcher){
        batcher.draw(water,water1.getX(),water1.getY(),water1.getWidth(),water1.getHeight());
        batcher.draw(water,water2.getX(),water2.getY(),water2.getWidth(),water2.getHeight());
    }
    public void drawClouds(Batch batcher){
        batcher.draw(cloud1.getCloud(),cloud1.getX(),cloud1.getY(),cloud1.getWidth(),cloud1.getHeight());
        batcher.draw(cloud2.getCloud(),cloud2.getX(),cloud2.getY(),cloud2.getWidth(),cloud2.getHeight());
        batcher.draw(cloud3.getCloud(),cloud3.getX(),cloud3.getY(),cloud3.getWidth(),cloud3.getHeight());
    }

    private void drawSky(){
        batcher.draw(sky,0,0,150,menuWorld.getMidpointY() * 2);
    }

    public void render(){
        Gdx.gl.glClearColor(26 / 255.0f, 205 / 255.0f, 255 / 255.0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        isPremium = game.getActionResolver().getPremiumInfo();

        camera.update();
        batcher.setProjectionMatrix(camera.combined);

        batcher.begin();
        drawSky();
        drawClouds(batcher);
        drawWater(batcher);

        if(!com.project.jumpfish.gamehelpers.AssetLoader.isUnlocked(com.project.jumpfish.gamehelpers.AssetLoader.getCharacterSelector())){
            com.project.jumpfish.gamehelpers.AssetLoader.setCharacterSelector(0);
        }

        switch (com.project.jumpfish.gamehelpers.AssetLoader.getCharacterSelector()){
            case 0:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 1:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 2:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 3:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor4Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 4:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor1Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 5:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor2Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 6:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor3Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 7:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor1Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 8:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor2Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 9:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor3Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 10:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor1Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 11:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor2Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            case 12:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor3Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
            default:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle,XPOS, YPOS, 32,32,64,64,SCALE,SCALE,0f);
                break;
        }
        batcher.draw(logo,width/2 - 62.5f,-10,125f/2f,54f/2f,125,54,0.5f,0.5f,0f);
        batcher.draw(currentCharacterSelected,XPOS,YPOS + 32,63f/2f,9f/2f,63,9,0.5f,0.5f,0f);
        playButton.draw(batcher);
        muteButton.draw(batcher);
        rateButton.draw(batcher);
        characterButton.draw(batcher);
        if(!isPremium){
            premiumButton.draw(batcher);
            noAdsButton.draw(batcher);
        }else{
            batcher.draw(premiumSign,width/2 - 35,height/2 - 10,14,5.5f,38,11,0.75f,0.75f,0f);
        }

        AssetLoader.ocra.draw(batcher,"( c ) 2015 Fred Vatnsdal All Rights Reserved.", width/2 - 45,height - 4);
        AssetLoader.ocra.draw(batcher,"v"+game.getActionResolver().getVerNum(),width - 10, 2);

        batcher.end();
    }
}
