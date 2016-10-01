package com.project.jumpfish.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.math.Rectangle;
import com.project.jumpfish.UI.SimpleButton;
import com.project.jumpfish.game.MGame;
import com.project.jumpfish.gamehelpers.AssetLoader;
import com.project.jumpfish.gameobjects.Background;
import com.project.jumpfish.gameobjects.Fish;
import com.project.jumpfish.gameobjects.Runner;
import com.project.jumpfish.gameobjects.Water;

import java.util.ArrayList;

/**
 * Created by Fred on 03/07/2015.
 */
public class GameRenderer {

        private int midPointY;
        private float runnerScale = 0.75f;
        private boolean adShown = false;
        private int adCount = 0;

        private GameWorld world;
        private OrthographicCamera cam;
        private ShapeRenderer shapeRenderer;

        private SpriteBatch batcher;

        private Runner runner;
        private com.project.jumpfish.gameobjects.ScrollHandler scrollHandler;
        private com.project.jumpfish.gameobjects.Foreground fg1,fg2;
        private com.project.jumpfish.gameobjects.Dirt dirt1,dirt2;
        private Background bg1, bg2;
        private Water w1,w2;
        private com.project.jumpfish.gameobjects.Cloud c1,c2,c3;
        private SimpleButton menuButton,okButton,buyButton;
        private com.project.jumpfish.gameobjects.Platform plt1,plt2,plt3;

        private TextureRegion foreground1,runnerJump,runnerIdle,platform,dirt,mountains,
                water,goldFishIcon,gameOverSign,retrySign,scoreBoard,sky,startSign;

        private Rectangle pcb1,pcb2,pcb3,
                pr1,pr2,pr3,runnerHB;

        private com.badlogic.gdx.graphics.g2d.Animation runnerAnimation,goldFishAnimtion;

        private ArrayList<Fish> fishs;

        private int score,midPointX;

        private MGame game;



        public GameRenderer(GameWorld gameWorld, int midPointY, int gameHeight,int gameWidth,int midPointX,MGame game){
            world = gameWorld;
            this.game = game;
            this.midPointX = midPointX;

            this.midPointY = midPointY;

            cam = new OrthographicCamera();
            cam.setToOrtho(true,gameWidth,gameHeight);

            batcher = new SpriteBatch();
            batcher.setProjectionMatrix(cam.combined);

            shapeRenderer = new ShapeRenderer();
            shapeRenderer.setProjectionMatrix(cam.combined);

            score = world.getScore();

            initGameObjects();
            initAssets();

        }

        private void initGameObjects(){
            scrollHandler = world.getScrollHandler();

            runner = world.getRunner();

            w1 = scrollHandler.getWater1();
            w2 = scrollHandler.getWater2();

            bg1 = scrollHandler.getBg1();
            bg2 = scrollHandler.getBg2();

            fg1 = scrollHandler.getFg1();
            fg2 = scrollHandler.getFg2();

            plt1 = scrollHandler.getPlatform1();
            plt2 = scrollHandler.getPlatform2();
            plt3 = scrollHandler.getPlatform3();

            pr1 = scrollHandler.getPlatform1().getPlatformBox();
            pr2 = scrollHandler.getPlatform2().getPlatformBox();
            pr3 = scrollHandler.getPlatform3().getPlatformBox();

            pcb1 = scrollHandler.getPlatform1().getPlatformContainsBox();
            pcb2 = scrollHandler.getPlatform2().getPlatformContainsBox();
            pcb3 = scrollHandler.getPlatform3().getPlatformContainsBox();

            dirt1 = scrollHandler.getD1();
            dirt2 = scrollHandler.getD2();

            c1 = scrollHandler.getCloud1();
            c2 = scrollHandler.getCloud2();
            c3 = scrollHandler.getCloud3();

            runnerHB = runner.getHitBox();

            fishs = world.getFishs();

            menuButton = world.getReturnToMenu();
            buyButton = world.getBuyButton();
            okButton = world.getOkButton();

        }

        private void initAssets(){
            runnerAnimation = runner.getRunnerAnimation();
            runnerIdle = runner.getRunnerIdle();
            runnerJump = runner.getRunnerJump();
            goldFishAnimtion = com.project.jumpfish.gamehelpers.AssetLoader.goldFishWiggle;
            goldFishIcon = com.project.jumpfish.gamehelpers.AssetLoader.goldFish2;
            water = com.project.jumpfish.gamehelpers.AssetLoader.water;
            foreground1 = com.project.jumpfish.gamehelpers.AssetLoader.fg1;
            mountains = com.project.jumpfish.gamehelpers.AssetLoader.mountain;
            platform = com.project.jumpfish.gamehelpers.AssetLoader.platform;
            dirt = com.project.jumpfish.gamehelpers.AssetLoader.dirt;
            gameOverSign = com.project.jumpfish.gamehelpers.AssetLoader.gameOverSign;
            retrySign = com.project.jumpfish.gamehelpers.AssetLoader.retrySign;
            scoreBoard = com.project.jumpfish.gamehelpers.AssetLoader.scoreBoard;
            sky = com.project.jumpfish.gamehelpers.AssetLoader.skyBox;
            startSign = com.project.jumpfish.gamehelpers.AssetLoader.startSign;

        }

        private void drawPlatforms(){
            batcher.draw(platform,pr1.getX(),pr1.getY(),pr1.getWidth(),pr1.getHeight());
            batcher.draw(platform,pr2.getX(),pr2.getY(),pr2.getWidth(),pr2.getHeight());
            batcher.draw(platform,pr3.getX(),pr3.getY(),pr3.getWidth(),pr3.getHeight());
        }


        private void drawDirt(){
            batcher.draw(dirt,dirt1.getX(),dirt1.getY(),dirt1.getWidth(),dirt1.getHeight());
            batcher.draw(dirt,dirt2.getX(),dirt2.getY(),dirt2.getWidth(),dirt2.getHeight());

        }

        private void drawForeground(){
            batcher.draw(foreground1,fg1.getX(),fg1.getY(),fg1.getWidth(),fg1.getHeight());
            batcher.draw(foreground1,fg2.getX(),fg2.getY(),fg2.getWidth(),fg2.getHeight());

        }

        private void drawBackground(){
            batcher.draw(mountains,bg1.getX(),bg1.getY(),bg1.getWidth(),bg1.getHeight());
            batcher.draw(mountains,bg2.getX(),bg2.getY(), bg2.getWidth(),bg2.getHeight());

        }

        private void drawRunner(float runTime){
            if (!runner.isJumping()) { //Do running animation
                batcher.draw(runnerAnimation.getKeyFrame(runTime), runner.getPositionX(), runner.getPositionY(), runner.getWidth() / 2.0f, runner.getHeight() / 2.0f, runner.getWidth(), runner.getHeight(),runnerScale, runnerScale, 0f);
            } else if (runner.isJumping()) { //Do jumping animation
                batcher.draw(runnerJump, runner.getPositionX(), runner.getPositionY(), runner.getWidth() / 2.0f, runner.getHeight() / 2.0f, runner.getWidth(), runner.getHeight(), runnerScale, runnerScale, 0f);
            }
        }
        private void drawRunnerIdle(){
            batcher.draw(runnerIdle, runner.getPositionX(), runner.getPositionY(), runner.getWidth() / 2.0f, runner.getHeight() / 2.0f, runner.getWidth(), runner.getHeight(), runnerScale, runnerScale, 0f);
        }

        private void drawWater(){
            batcher.draw(water,w1.getX(),w1.getY(),w1.getWidth(),w1.getHeight());
            batcher.draw(water,w2.getX(),w2.getY(),w2.getWidth(),w2.getHeight());
        }

        private void drawClouds(){
            batcher.draw(c1.getCloud(),c1.getX(),c1.getY(),c1.getWidth()/2,c1.getHeight()/2,c1.getWidth(),c1.getHeight(),1f,1f,0f);
            batcher.draw(c2.getCloud(),c2.getX(),c2.getY(),c2.getWidth()/2,c2.getHeight()/2,c2.getWidth(),c2.getHeight(),1f,1f,0f);
            batcher.draw(c3.getCloud(),c3.getX(),c3.getY(),c3.getWidth()/2,c3.getHeight()/2,c3.getWidth(),c3.getHeight(),1f,1f,0f);
        }

        private void drawFish(float runTime){
            for(Fish f: fishs){
                batcher.draw(goldFishAnimtion.getKeyFrame(runTime),f.getX(),f.getY(),f.getWidth()/2.0f,f.getHeight()/2.0f,f.getWidth(),f.getHeight(),1.0f,1.0f,f.getRotation());
                Gdx.app.log("fishs",f + " Xpos: " + f.getX() + " Ypos: " + f.getY());
            }
        }

        private void drawSky(){
            batcher.draw(sky,0,0,150,midPointY*2);
        }

        public void render(float runTime) {
            Gdx.app.log("GameRenderer", "render");

            score = world.getScore();
            fishs = world.getFishs();

            runnerAnimation = runner.getRunnerAnimation();
            runnerIdle = runner.getRunnerIdle();
            runnerJump = runner.getRunnerJump();


            //SKY
           /* shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(153 / 255.0f, 195 / 255.0f, 174 / 255.0f, 0);
            shapeRenderer.rect(0, 0, 150, midPointY * 2);
            shapeRenderer.end();*/


            batcher.begin();
            drawSky();
            drawBackground();
            drawClouds();
            drawForeground();
            drawDirt();
            drawFish(runTime);
            drawWater();
            drawPlatforms();



            if(world.getCurrentState() == GameWorld.GameState.RUNNING) {
                drawRunner(runTime);
                batcher.draw(goldFishIcon,midPointX+30,0,8,8,16,16,0.5f,0.5f,45);
                AssetLoader.blockfont.draw(batcher, score + "", midPointX + 40, 1);
            }
            else{
                drawRunnerIdle();
                if(world.getCurrentState() == GameWorld.GameState.READY) {
                    adShown = false;
                    batcher.draw(startSign,midPointX - 32.5f, midPointY - 23,65,20);
                }

                else if(world.getCurrentState() == GameWorld.GameState.GAMEOVER){
                    batcher.draw(scoreBoard,midPointX - 40,midPointY-16,40,16,80,32,1.0f,1.0f,0f);
                    batcher.draw(gameOverSign,midPointX-24,midPointY - 29,24,7,48,11,1.5f,1.5f,0f);
                    batcher.draw(retrySign,midPointX-24,midPointY + 17,24,7,48,11,1.15f,1.15f,0f);
                    menuButton.draw(batcher);
                    okButton.draw(batcher);

                    if (!adShown) {
                        if(adCount < 1){
                            game.getActionResolver().showAd();
                            adCount ++;
                        }
                        else{
                            adCount = 0;
                        }
                        adShown = true;
                    }


                    if(!game.getActionResolver().getPremiumInfo()){
                        buyButton.draw(batcher);
                    }

                    AssetLoader.blockfont.draw(batcher, score + "", 43, midPointY);
                    AssetLoader.blockfont.draw(batcher, com.project.jumpfish.gamehelpers.AssetLoader.getHighScore() + "", 82, midPointY);
                }

            }
           /*batcher.disableBlending();

            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(0/250.0f,0/250.0f,100/250.0f,0);
            shapeRenderer.rect(midPointX,midPointY,10,10);
            shapeRenderer.rect(pcb1.getX(),pcb1.getY(),pcb1.getWidth(),pcb1.getHeight());

            shapeRenderer.rect(pcb2.getX(),pcb2.getY(),pcb2.getWidth(),pcb2.getHeight());

            shapeRenderer.rect(pcb3.getX(),pcb3.getY(),pcb3.getWidth(),pcb3.getHeight());

            shapeRenderer.setColor(0/250.0f,100/250.0f,0/250.0f,0);
            shapeRenderer.rect(runner.getHitBoxBody().getX(),runner.getHitBoxBody().getY(),runner.getHitBoxBody().getWidth(),runner.getHitBoxBody().getHeight());

            shapeRenderer.setColor(200/250.0f, 0/250.0f, 0/250.0f, 0);
            shapeRenderer.rect(runnerHB.getX(),runnerHB.getY(),runnerHB.getWidth(),runnerHB.getHeight());
            shapeRenderer.setColor(40/250.0f,40/250.0f,40/250.0f,0);
            shapeRenderer.rect(w1.getWaterHitbox().getX(),w1.getWaterHitbox().getY(),w1.getWaterHitbox().getWidth(),w1.getWaterHitbox().getHeight());

            shapeRenderer.end();*/


            batcher.end();
        }
}
