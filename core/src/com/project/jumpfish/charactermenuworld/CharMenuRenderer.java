package com.project.jumpfish.charactermenuworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.gamehelpers.AssetLoader;

/**
 * Created by Fred on 03/08/2015.
 */
public class CharMenuRenderer {
    private CharMenuWorld charMenuWorld;
    private OrthographicCamera camera;
    private SpriteBatch batcher;

    private SimpleButton unlockButton, arrowLeftButton, arrowRightButton, doneButton;

    private com.project.jumpfish.gameobjects.Water water1,water2;
    private com.project.jumpfish.gameobjects.Cloud cloud1,cloud2,cloud3;

    private TextureRegion water,sky,premiumOnlySign;

    private float width,height;

    private  float XPOS;
    private  float YPOS;

    public CharMenuRenderer(int midPointY,float width, float height,CharMenuWorld charMenuWorld){
        this.charMenuWorld = charMenuWorld;
        camera = new OrthographicCamera();
        camera.setToOrtho(true,width,height);

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        this.width = width;
        this.height = height;

        XPOS = width/2 - 32;
        YPOS = height/2 - 36;

        initObjects();
        initTextures();

    }

    public void initObjects(){
        unlockButton = charMenuWorld.getUnlockButton();
        arrowLeftButton = charMenuWorld.getArrowLeftBtn();
        arrowRightButton = charMenuWorld.getArrowRightBtn();
        doneButton = charMenuWorld.getDoneBtn();

        cloud1 = charMenuWorld.getMenuScrollHandler().getCloud1();
        cloud2 = charMenuWorld.getMenuScrollHandler().getCloud2();
        cloud3 = charMenuWorld.getMenuScrollHandler().getCloud3();

        water1 = charMenuWorld.getMenuScrollHandler().getWater1();
        water2 = charMenuWorld.getMenuScrollHandler().getWater2();
    }

    public void initTextures(){
        water = com.project.jumpfish.gamehelpers.AssetLoader.water;
        sky = com.project.jumpfish.gamehelpers.AssetLoader.skyBox;
        premiumOnlySign = AssetLoader.premiumOnlySign;
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
        batcher.draw(sky,0,0,150,charMenuWorld.getMidPointY() * 2);
    }

    public void render(){
        Gdx.gl.glClearColor(26/255.0f, 205/255.0f, 255/255.0f, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batcher.setProjectionMatrix(camera.combined);

        batcher.begin();
        drawSky();
        drawClouds(batcher);
        drawWater(batcher);
       switch (com.project.jumpfish.gamehelpers.AssetLoader.getCharacterSelector()){
            case 0:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor1Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 1:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 2:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor3Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 3:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor4Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 4:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor1Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 5:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor2Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 6:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.wraithColor3Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 7:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor1Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 8:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor2Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 9:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.diverColor3Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 10:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor1Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 11:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor2Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            case 12:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.bearColor3Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
            default:
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.runnerColor2Idle,XPOS, YPOS, 32,32,64,64,0.75f,0.75f,0f);
                break;
        }
        batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.priceSign, width / 2 - 19, 0, 50, 11);
        if(!com.project.jumpfish.gamehelpers.AssetLoader.isUnlocked(com.project.jumpfish.gamehelpers.AssetLoader.getCharacterSelector())){
            batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.lock,width/2 - 7,height/2 - 6, 9,14); //width/2 -7 height/3 -4
            if(AssetLoader.getCharacterPrice(AssetLoader.getCharacterSelector()) == -1){
                batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.unlockedSign,(width/2 - 20), height*(4f/5f), 40, 10); //width/2 - 20, height/2 + 10
                AssetLoader.bitfontsmall.draw(batcher, "N/A", width / 2 + 5, 3);
                batcher.draw(premiumOnlySign,width/2 - 30,height/2 + 2,60f/2f,11f/2f,60,11,0.5f,0.5f,0f);
            }else {
                AssetLoader.bitfontsmall.draw(batcher, com.project.jumpfish.gamehelpers.AssetLoader.getCharacterPrice(com.project.jumpfish.gamehelpers.AssetLoader.getCharacterSelector()) + "", width / 2 + 5, 3);
            }
            unlockButton.draw(batcher);
        }
        else{
            batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.unlockedSign, (width / 2 - 20), height * (4f / 5f), 40, 10); //width/2 - 20, height/2 + 10
            AssetLoader.bitfontsmall.draw(batcher, "N/A", width / 2 + 5, 3);
        }
        batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.totalFishSign, 0, 0, 50, 14);
        com.project.jumpfish.gamehelpers.AssetLoader.bitfontsmall.draw(batcher, com.project.jumpfish.gamehelpers.AssetLoader.getTotalFish() + " ", 25, 3);
        batcher.draw(com.project.jumpfish.gamehelpers.AssetLoader.doneSign, width - 20.5f, height - 30, 20, 9);
        arrowRightButton.draw(batcher);
        arrowLeftButton.draw(batcher);
        doneButton.draw(batcher);
        batcher.end();
    }
}
