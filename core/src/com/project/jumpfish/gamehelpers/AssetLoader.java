package com.project.jumpfish.gamehelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.project.jumpfish.game.MGame;


/**
 * Created by Fred on 03/07/2015.
 */
public class AssetLoader {

    public static Texture sky;
    public static Texture spriteSheet;

    //****RUNNER****
    //****TEXTURE REGIONS FOR COLOR 1****
    public static TextureRegion runnerColor1Run1,runnerColor1Run2,runnerColor1Run3,runnerColor1Run4;
    public static TextureRegion runnerColor1Jump;
    public static TextureRegion runnerColor1Idle;

    //****TEXTURE REGIONS FOR COLOR 2****
    public static TextureRegion runnerColor2Run1,runnerColor2Run2,runnerColor2Run3,runnerColor2Run4;
    public static TextureRegion runnerColor2Jump;
    public static TextureRegion runnerColor2Idle;

    //****TEXTURE REGIONS FOR COLOR 3****
    public static TextureRegion runnerColor3Run1,runnerColor3Run2,runnerColor3Run3,runnerColor3Run4;
    public static TextureRegion runnerColor3Jump;
    public static TextureRegion runnerColor3Idle;

    //****TEXTURE REGIONS FOR COLOR 4****
    public static TextureRegion runnerColor4Run1,runnerColor4Run2,runnerColor4Run3,runnerColor4Run4;
    public static TextureRegion runnerColor4Jump;
    public static TextureRegion runnerColor4Idle;

    //****WRAITH COLOR 1****
    public static TextureRegion wraithColor1Run1,wraithColor1Run2,wraithColor1Run3,wraithColor1Run4;
    public static TextureRegion wraithColor1Jump;
    public static TextureRegion wraithColor1Idle;

    //****WRAITH COLOR 2****
    public static TextureRegion wraithColor2Run1,wraithColor2Run2,wraithColor2Run3,wraithColor2Run4;
    public static TextureRegion wraithColor2Jump;
    public static TextureRegion wraithColor2Idle;

    //****WRAITH COLOR 3****
    public static TextureRegion wraithColor3Run1,wraithColor3Run2,wraithColor3Run3,wraithColor3Run4;
    public static TextureRegion wraithColor3Jump;
    public static TextureRegion wraithColor3Idle;

    //****DIVER COLOR 1****
    public static TextureRegion diverColor1Run1,diverColor1Run2,diverColor1Run3,diverColor1Run4;
    public static TextureRegion diverColor1Jump;
    public static TextureRegion diverColor1Idle;

    //****DIVER COLOR 2****
    public static TextureRegion diverColor2Run1,diverColor2Run2,diverColor2Run3,diverColor2Run4;
    public static TextureRegion diverColor2Jump;
    public static TextureRegion diverColor2Idle;

    //****DIVER COLOR 3****
    public static TextureRegion diverColor3Run1,diverColor3Run2,diverColor3Run3,diverColor3Run4;
    public static TextureRegion diverColor3Jump;
    public static TextureRegion diverColor3Idle;

    //****BEAR COLOR 1****
    public static TextureRegion bearColor1Run1,bearColor1Run2,bearColor1Run3,bearColor1Run4;
    public static TextureRegion bearColor1Jump;
    public static TextureRegion bearColor1Idle;

    //****BEAR COLOR 2****
    public static TextureRegion bearColor2Run1,bearColor2Run2,bearColor2Run3,bearColor2Run4;
    public static TextureRegion bearColor2Jump;
    public static TextureRegion bearColor2Idle;

    //****BEAR COLOR 3****
    public static TextureRegion bearColor3Run1,bearColor3Run2,bearColor3Run3,bearColor3Run4;
    public static TextureRegion bearColor3Jump;
    public static TextureRegion bearColor3Idle;

    public static TextureRegion platform,dirt;
    public static TextureRegion fg1;
    public static TextureRegion mountain;
    public static TextureRegion water;
    public static TextureRegion goldFish1,goldFish2,goldFish3,goldFish4;
    public static TextureRegion scoreBoard;
    public static TextureRegion gameOverSign,readySign,retrySign;
    public static TextureRegion cloud1,cloud2,cloud3;
    public static TextureRegion lock,lockedSign;
    public static TextureRegion unlockedSign;
    public static TextureRegion totalFishSign, priceSign;
    public static TextureRegion tapGuide;
    public static TextureRegion doneSign;
    public static TextureRegion startSign;
    public static TextureRegion currentCharacterSign;
    public static TextureRegion premiumOnlySign;

    //*****BUTTONS******
    public static TextureRegion playButtonUp,playButtonDown;
    public static TextureRegion unlockButtonUp,unlockButtonDown;
    public static TextureRegion rateButtonUp,rateButtonDown;
    public static TextureRegion okButtonUp,okButtonDown;
    public static TextureRegion doneButtonUp, doneButtonDown;
    public static TextureRegion characterButtonUp,characterButtonDown;
    public static TextureRegion menuButtonUp,menuButtonDown;
    public static TextureRegion arrowLeftUp, arrowLeftDown, arrowRightUp, arrowRightDown;
    public static TextureRegion muteButtonUp,muteButtonDown;
    public static TextureRegion premiumButtonUp,premiumButtonDown;
    public static TextureRegion bigBuyButtonUp,bigBuyButtonDown;
    public static TextureRegion smallBuyButtonUp,smallBuyButtonDown;
    public static TextureRegion noAdsButtonUp, noAdsButtonDown;

    public static TextureRegion skyBox;
    public static TextureRegion logo;

    public static Sound jump,catchFish,death,click,unlock,splash;
    public static Animation runnerColor1Anim,runnerColor2Anim,runnerColor3Anim,runnerColor4Anim;
    public static Animation runnerColor1WraithAnim,runnerColor2WraithAnim,runnerColor3WraithAnim;
    public static Animation runnerColor1DiverAnim,runnerColor2DiverAnim,runnerColor3DiverAnim;
    public static Animation runnerColor1BearAnim, runnerColor2BearAnim, runnerColor3BearAnim;
    public static Animation goldFishWiggle;

    public static BitmapFont ocra,bitfontsmall,blockfont;

    private static Preferences preferences;
    private static int prevscore;
    private static int characterSelector = 0;
    private static final int NUMBEROFCHARACTERS = 12;
    public static final int RUNNER_COST = 400;

    private static MGame mgame;


    public static void load(MGame game) {
        mgame = game;

        spriteSheet = new Texture(Gdx.files.internal("data/spritesheet.png"));
        spriteSheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        sky = new Texture(Gdx.files.internal("data/sky.png"));
        sky.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        //*****PREMIUM ONLY*****
        premiumOnlySign = new TextureRegion(spriteSheet,512,245,60,11);
        premiumOnlySign.flip(false,true);

        //*****PREMIUM*****
        premiumButtonUp = new TextureRegion(spriteSheet,448,169,38,11);
        premiumButtonUp.flip(false, true);
        premiumButtonDown = new TextureRegion(spriteSheet,486,169,38,11);
        premiumButtonDown.flip(false,true);

        //*****SMALL BUY BUTTON*****
        smallBuyButtonUp = new TextureRegion(spriteSheet,448,182,48,9);
        smallBuyButtonUp.flip(false,true);
        smallBuyButtonDown = new TextureRegion(spriteSheet,496,182,48,9);
        smallBuyButtonDown.flip(false,true);

        //*****BIG BUY BUTTON*****
        bigBuyButtonUp = new TextureRegion(spriteSheet,576,225,55,11);
        bigBuyButtonUp.flip(false,true);
        bigBuyButtonDown = new TextureRegion(spriteSheet,576,236,55,11);
        bigBuyButtonDown.flip(false,true);

        //*****NO ADS BUTTON******
        noAdsButtonUp = new TextureRegion(spriteSheet,128,576,24,24);
        noAdsButtonUp.flip(false,true);
        noAdsButtonDown = new TextureRegion(spriteSheet,152,576,24,24);
        noAdsButtonDown.flip(false,true);


        //*****CURRENT CHARACTER SIGN*****
        currentCharacterSign = new TextureRegion(spriteSheet,448,160,63,9);
        currentCharacterSign.flip(false,true);
        //*****START SIGN  SETUP*****
        startSign = new TextureRegion(spriteSheet,563,104,65,20);
        startSign.flip(false,true);

        //*****LOGO SETUP*****
        logo = new TextureRegion(spriteSheet,0,576,125,54);
        logo.flip(false, true);

        //*****SKY SETUP*****
        skyBox = new TextureRegion(sky,0,0,448,256);
        skyBox.flip(false,true);

        //*****FOREGROUND SETUP*****

        fg1 = new TextureRegion(spriteSheet, 0, 0, 448, 256);
        fg1.flip(false, true);

        //*****BACKGROUND SETUP*****

        mountain = new TextureRegion(spriteSheet, 0, 256, 640, 320);
        mountain.flip(false, true);
        //*****RUNNER SETUP*****
        loadRunnerColorations();

        //*****PLATFORM TILE SETUP*****
        platform = new TextureRegion(spriteSheet, 448, 192, 64, 64);
        platform.flip(false, true);

        //*****DIRT BACKGROUND SETUP*****
        dirt = new TextureRegion(spriteSheet, 560, 64, 16, 16);
        dirt.flip(false, true);

        //*****WATER SETUP*****
        water = new TextureRegion(spriteSheet, 448, 128, 160, 32);
        water.flip(false, true);

        //*****GOLDFISH ANIMATION SETUP*****
        goldFish1 = new TextureRegion(spriteSheet, 512, 0, 32, 32);
        goldFish1.flip(false, true);
        goldFish2 = new TextureRegion(spriteSheet, 544, 0, 32, 32);
        goldFish2.flip(false, true);
        goldFish3 = new TextureRegion(spriteSheet, 576, 0, 32, 32);
        goldFish3.flip(false, true);
        goldFish4 = new TextureRegion(spriteSheet, 608, 0, 32, 32);
        goldFish4.flip(false, true);

        TextureRegion[] goldFishSlides = {goldFish1, goldFish2, goldFish3, goldFish4};
        goldFishWiggle = new Animation(0.1f, goldFishSlides);
        goldFishWiggle.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****TEXT SIGNS SETUP*****
        gameOverSign = new TextureRegion(spriteSheet, 512, 64, 48, 11);
        gameOverSign.flip(false, true);

        readySign = new TextureRegion(spriteSheet, 512, 75, 48, 12);
        readySign.flip(false, true);

        retrySign = new TextureRegion(spriteSheet, 512, 87, 48, 12);
        retrySign.flip(false, true);

        //*****SCOREBOARD SIGN SETUP*****
        scoreBoard = new TextureRegion(spriteSheet, 512, 32, 80, 32);
        scoreBoard.flip(false, true);

        //*****FISH + PRICE SIGNS SETUP*****
        totalFishSign = new TextureRegion(spriteSheet,512,99,51,14);
        totalFishSign.flip(false,true);

        priceSign = new TextureRegion(spriteSheet,512,113,51,11);
        priceSign.flip(false,true);

        //*****UNLOCKED SIGN*****
        unlockedSign = new TextureRegion(spriteSheet,551,212,40,10);
        unlockedSign.flip(false,true);


        //*****SETUP PREFERENCES*****
        preferences = Gdx.app.getPreferences("runnergame");
        if (!preferences.contains("highscore")) {
            preferences.putInteger("highscore",0);
        }
        if(!preferences.contains("charSelect")){
            preferences.putInteger("charSelect",0);
        }
        if(!preferences.contains("totalFish")) {
            preferences.putInteger("totalFish", 0);
        }
        if(!preferences.contains("muteState")){
            preferences.putBoolean("muteState", false);
        }
        if(!preferences.contains("runner_1")){
            preferences.putBoolean("runner_1",true);
        }
        if(!preferences.contains("runner_2")){
            preferences.putBoolean("runner_2",false);
        }
        if(!preferences.contains("runner_3")){
            preferences.putBoolean("runner_3",false);
        }
        if(!preferences.contains("runner_4")){
            preferences.putBoolean("runner_4",false);
        }


        //*****PLAYBUTTON SETUP*****
        playButtonUp = new TextureRegion(spriteSheet,576,64, 41, 20);
        playButtonUp.flip(false, true);
        playButtonDown = new TextureRegion(spriteSheet,576, 84, 41, 20);
        playButtonDown.flip(false, true);

        //*****RIGHT/LEFT ARROWS*****
        arrowLeftUp = new TextureRegion(spriteSheet,560,160,16,16);
        arrowLeftDown = new TextureRegion(spriteSheet,576,160,16,16);
        arrowRightUp = new TextureRegion(spriteSheet,560,160,16,16);
        arrowRightDown = new TextureRegion(spriteSheet,576,160,16,16);

        arrowLeftUp.flip(false,true);
        arrowRightUp.flip(true,true);
        arrowLeftDown.flip(false,true);
        arrowRightDown.flip(true,true);

        //*****MENU BUTTON*****
        menuButtonUp = new TextureRegion(spriteSheet,551,222,25,10);
        menuButtonUp.flip(false,true);
        menuButtonDown = new TextureRegion(spriteSheet,551,232,25,10);
        menuButtonDown.flip(false,true);

        //****UNLOCK BUTTON****
        unlockButtonUp = new TextureRegion(spriteSheet,512,212,39,10);
        unlockButtonUp.flip(false,true);
        unlockButtonDown = new TextureRegion(spriteSheet,512,222,39,10);
        unlockButtonDown.flip(false,true);

        //****RATE BUTTON****
        rateButtonUp = new TextureRegion(spriteSheet,605,160,18,9);
        rateButtonUp.flip(false,true);
        rateButtonDown = new TextureRegion(spriteSheet,605,169,18,9);
        rateButtonDown.flip(false,true);

        //****CHARACTERS BUTTON****
        characterButtonUp = new TextureRegion(spriteSheet,592,32,44,16);
        characterButtonUp.flip(false,true);
        characterButtonDown = new TextureRegion(spriteSheet,592,48,44,16);
        characterButtonDown.flip(false,true);

        //****MUTE BUTTON****
        muteButtonUp = new TextureRegion(spriteSheet,560,180,14,12);
        muteButtonUp.flip(false,true);
        muteButtonDown = new TextureRegion(spriteSheet,577,180,14,12);
        muteButtonDown.flip(false,true);

        //****OK BUTTON****
        okButtonUp = new TextureRegion(spriteSheet,608,142,32,9);
        okButtonUp.flip(false,true);
        okButtonDown = new TextureRegion(spriteSheet,608,151,32,9);
        okButtonDown.flip(false,true);

        //****DONE BUTTON****
        doneButtonUp = new TextureRegion(spriteSheet,596,189,14,18);
        doneButtonUp.flip(false,true);
        doneButtonDown = new TextureRegion(spriteSheet,596,207,14,18);
        doneButtonDown.flip(false, true);

        //****DONE SIGN****
        doneSign = new TextureRegion(spriteSheet,596,179,20,9);
        doneSign.flip(false,true);

        //****TAP GUIDE****
        tapGuide = new TextureRegion(spriteSheet,566,192,28,20);
        tapGuide.flip(false,true);

        //****LOCK AND LOCKED SIGN****
        lockedSign = new TextureRegion(spriteSheet,583,99,30,10);
        lockedSign.flip(false,true);
        lock = new TextureRegion(spriteSheet,623,160,9,14);
        lock.flip(false,true);


        //*****CLOUDS SETUP*****
        cloud1 = new TextureRegion(spriteSheet, 448, 0, 64, 32);
        cloud1.flip(false, true);
        cloud2 = new TextureRegion(spriteSheet, 448, 32, 64, 32);
        cloud2.flip(false, true);
        cloud3 = new TextureRegion(spriteSheet, 448, 64, 64, 32);
        cloud3.flip(false, true);

        //*****FONTS*****
        ocra = new BitmapFont(Gdx.files.internal("data/bitfont.fnt"));
        ocra.getData().setScale(0.1f, -0.1f);
        bitfontsmall = new BitmapFont(Gdx.files.internal("data/bitfont.fnt"));
        bitfontsmall.getData().setScale(0.2f,-0.2f);
        blockfont = new BitmapFont(Gdx.files.internal("data/block_42s.fnt"));
        blockfont.getData().setScale(0.25f,-0.25f);

        characterSelector = getCharacter();

        setupSounds();
    }

    public static void loadRunnerColorations(){
        //**********Color 1**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        runnerColor1Run1 = new TextureRegion(spriteSheet, 640, 0, 64, 64);
        runnerColor1Run1.flip(false, true);
        runnerColor1Run2 = new TextureRegion(spriteSheet, 704, 0, 64, 64);
        runnerColor1Run2.flip(false, true);
        runnerColor1Run3 = new TextureRegion(spriteSheet, 768, 0, 64, 64);
        runnerColor1Run3.flip(false, true);
        runnerColor1Run4 = new TextureRegion(spriteSheet, 832, 0, 64, 64);
        runnerColor1Run4.flip(false, true);

        TextureRegion[] runnerColor1Slides = {runnerColor1Run1, runnerColor1Run2, runnerColor1Run3, runnerColor1Run4};
        runnerColor1Anim = new Animation(0.1f, runnerColor1Slides);
        runnerColor1Anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        runnerColor1Jump = new TextureRegion(spriteSheet, 768, 0, 64, 64);
        runnerColor1Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        runnerColor1Idle = new TextureRegion(spriteSheet,832, 0, 64, 64);
        runnerColor1Idle.flip(false, true);

        //**********Color 2**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        runnerColor2Run1 = new TextureRegion(spriteSheet, 640, 64, 64, 64);
        runnerColor2Run1.flip(false, true);
        runnerColor2Run2 = new TextureRegion(spriteSheet, 704, 64, 64, 64);
        runnerColor2Run2.flip(false, true);
        runnerColor2Run3 = new TextureRegion(spriteSheet, 768, 64, 64, 64);
        runnerColor2Run3.flip(false, true);
        runnerColor2Run4 = new TextureRegion(spriteSheet, 832, 64, 64, 64);
        runnerColor2Run4.flip(false, true);

        TextureRegion[] runnerColor2Slides = {runnerColor2Run1, runnerColor2Run2, runnerColor2Run3, runnerColor2Run4};
        runnerColor2Anim = new Animation(0.1f, runnerColor2Slides);
        runnerColor2Anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        runnerColor2Jump = new TextureRegion(spriteSheet, 768, 64, 64, 64);
        runnerColor2Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        runnerColor2Idle = new TextureRegion(spriteSheet,832, 64, 64, 64);
        runnerColor2Idle.flip(false, true);

        //**********Color 3**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        runnerColor3Run1 = new TextureRegion(spriteSheet, 640, 128, 64, 64);
        runnerColor3Run1.flip(false, true);
        runnerColor3Run2 = new TextureRegion(spriteSheet, 704, 128, 64, 64);
        runnerColor3Run2.flip(false, true);
        runnerColor3Run3 = new TextureRegion(spriteSheet, 768, 128, 64, 64);
        runnerColor3Run3.flip(false, true);
        runnerColor3Run4 = new TextureRegion(spriteSheet, 832, 128, 64, 64);
        runnerColor3Run4.flip(false, true);

        TextureRegion[] runnerColor3Slides = {runnerColor3Run1, runnerColor3Run2, runnerColor3Run3, runnerColor3Run4};
        runnerColor3Anim = new Animation(0.1f, runnerColor3Slides);
        runnerColor3Anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        runnerColor3Jump = new TextureRegion(spriteSheet, 768, 128, 64, 64);
        runnerColor3Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        runnerColor3Idle = new TextureRegion(spriteSheet,832, 128, 64, 64);
        runnerColor3Idle.flip(false, true);

        //**********Color 4**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        runnerColor4Run1 = new TextureRegion(spriteSheet, 640, 192, 64, 64);
        runnerColor4Run1.flip(false, true);
        runnerColor4Run2 = new TextureRegion(spriteSheet, 704, 192, 64, 64);
        runnerColor4Run2.flip(false, true);
        runnerColor4Run3 = new TextureRegion(spriteSheet, 768, 192, 64, 64);
        runnerColor4Run3.flip(false, true);
        runnerColor4Run4 = new TextureRegion(spriteSheet, 832, 192, 64, 64);
        runnerColor4Run4.flip(false, true);

        TextureRegion[] runnerColor4Slides = {runnerColor4Run1, runnerColor4Run2, runnerColor4Run3, runnerColor4Run4};
        runnerColor4Anim = new Animation(0.1f, runnerColor4Slides);
        runnerColor4Anim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        runnerColor4Jump = new TextureRegion(spriteSheet, 768, 192, 64, 64);
        runnerColor4Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        runnerColor4Idle = new TextureRegion(spriteSheet,832, 192, 64, 64);
        runnerColor4Idle.flip(false, true);


        //**********WRAITH COLOR 1**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        wraithColor1Run1 = new TextureRegion(spriteSheet, 640, 256, 64, 64);
        wraithColor1Run1.flip(false, true);
        wraithColor1Run2 = new TextureRegion(spriteSheet, 704, 256, 64, 64);
        wraithColor1Run2.flip(false, true);
        wraithColor1Run3 = new TextureRegion(spriteSheet, 768, 256, 64, 64);
        wraithColor1Run3.flip(false, true);
        wraithColor1Run4 = new TextureRegion(spriteSheet, 832, 256, 64, 64);
        wraithColor1Run4.flip(false, true);

        TextureRegion[]  wraithSlides1 = {wraithColor1Run1, wraithColor1Run2, wraithColor1Run3, wraithColor1Run4};
        runnerColor1WraithAnim = new Animation(0.1f, wraithSlides1);
        runnerColor1WraithAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        wraithColor1Jump = new TextureRegion(spriteSheet, 768, 256, 64, 64);
        wraithColor1Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        wraithColor1Idle = new TextureRegion(spriteSheet,832, 256, 64, 64);
        wraithColor1Idle.flip(false, true);


        //**********WRAITH COLOR 2**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        wraithColor2Run1 = new TextureRegion(spriteSheet, 640, 320, 64, 64);
        wraithColor2Run1.flip(false, true);
        wraithColor2Run2 = new TextureRegion(spriteSheet, 704, 320, 64, 64);
        wraithColor2Run2.flip(false, true);
        wraithColor2Run3 = new TextureRegion(spriteSheet, 768, 320, 64, 64);
        wraithColor2Run3.flip(false, true);
        wraithColor2Run4 = new TextureRegion(spriteSheet, 832, 320, 64, 64);
        wraithColor2Run4.flip(false, true);

        TextureRegion[]  wraithSlides2 = {wraithColor2Run1, wraithColor2Run2, wraithColor2Run3, wraithColor2Run4};
        runnerColor2WraithAnim = new Animation(0.1f, wraithSlides2);
        runnerColor2WraithAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        wraithColor2Jump = new TextureRegion(spriteSheet,768, 320, 64, 64);
        wraithColor2Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        wraithColor2Idle = new TextureRegion(spriteSheet,832, 320, 64, 64);
        wraithColor2Idle.flip(false, true);


        //**********WRAITH COLOR 3**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        wraithColor3Run1 = new TextureRegion(spriteSheet, 640, 384, 64, 64);
        wraithColor3Run1.flip(false, true);
        wraithColor3Run2 = new TextureRegion(spriteSheet, 704, 384, 64, 64);
        wraithColor3Run2.flip(false, true);
        wraithColor3Run3 = new TextureRegion(spriteSheet, 768, 384, 64, 64);
        wraithColor3Run3.flip(false, true);
        wraithColor3Run4 = new TextureRegion(spriteSheet, 832, 384, 64, 64);
        wraithColor3Run4.flip(false, true);

        TextureRegion[]  wraithSlides3 = {wraithColor3Run1, wraithColor3Run2, wraithColor3Run3, wraithColor3Run4};
        runnerColor3WraithAnim = new Animation(0.1f, wraithSlides3);
        runnerColor3WraithAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        wraithColor3Jump = new TextureRegion(spriteSheet,768, 384, 64, 64);
        wraithColor3Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        wraithColor3Idle = new TextureRegion(spriteSheet,832, 384, 64, 64);
        wraithColor3Idle.flip(false, true);

        //**********DIVER COLOR 1**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        diverColor1Run1 = new TextureRegion(spriteSheet, 640, 448, 64, 64);
        diverColor1Run1.flip(false, true);
        diverColor1Run2 = new TextureRegion(spriteSheet, 704, 448, 64, 64);
        diverColor1Run2.flip(false, true);
        diverColor1Run3 = new TextureRegion(spriteSheet, 768, 448, 64, 64);
        diverColor1Run3.flip(false, true);
        diverColor1Run4 = new TextureRegion(spriteSheet, 832, 448, 64, 64);
        diverColor1Run4.flip(false, true);

        TextureRegion[]  diverSlides1 = {diverColor1Run1, diverColor1Run2, diverColor1Run3, diverColor1Run4};
        runnerColor1DiverAnim = new Animation(0.1f, diverSlides1);
        runnerColor1DiverAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        diverColor1Jump = new TextureRegion(spriteSheet,768, 448, 64, 64);
        diverColor1Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        diverColor1Idle = new TextureRegion(spriteSheet,832, 448, 64, 64);
        diverColor1Idle.flip(false, true);

        //**********DIVER COLOR 2**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        diverColor2Run1 = new TextureRegion(spriteSheet, 640, 512, 64, 64);
        diverColor2Run1.flip(false, true);
        diverColor2Run2 = new TextureRegion(spriteSheet, 704, 512, 64, 64);
        diverColor2Run2.flip(false, true);
        diverColor2Run3 = new TextureRegion(spriteSheet, 768, 512, 64, 64);
        diverColor2Run3.flip(false, true);
        diverColor2Run4 = new TextureRegion(spriteSheet, 832, 512, 64, 64);
        diverColor2Run4.flip(false, true);

        TextureRegion[]  diverSlides2 = {diverColor2Run1, diverColor2Run2, diverColor2Run3, diverColor2Run4};
        runnerColor2DiverAnim = new Animation(0.1f, diverSlides2);
        runnerColor2DiverAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        diverColor2Jump = new TextureRegion(spriteSheet,768, 512, 64, 64);
        diverColor2Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        diverColor2Idle = new TextureRegion(spriteSheet,832, 512, 64, 64);
        diverColor2Idle.flip(false, true);


        //**********DIVER COLOR 3**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        diverColor3Run1 = new TextureRegion(spriteSheet, 640, 576, 64, 64);
        diverColor3Run1.flip(false, true);
        diverColor3Run2 = new TextureRegion(spriteSheet, 704, 576, 64, 64);
        diverColor3Run2.flip(false, true);
        diverColor3Run3 = new TextureRegion(spriteSheet, 768, 576, 64, 64);
        diverColor3Run3.flip(false, true);
        diverColor3Run4 = new TextureRegion(spriteSheet, 832, 576, 64, 64);
        diverColor3Run4.flip(false, true);

        TextureRegion[]  diverSlides3 = {diverColor3Run1, diverColor3Run2, diverColor3Run3, diverColor3Run4};
        runnerColor3DiverAnim = new Animation(0.1f, diverSlides3);
        runnerColor3DiverAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        diverColor3Jump = new TextureRegion(spriteSheet,768, 576, 64, 64);
        diverColor3Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        diverColor3Idle = new TextureRegion(spriteSheet,832, 576, 64, 64);
        diverColor3Idle.flip(false, true);


        //**********BEAR COLOR 1**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        bearColor1Run1 = new TextureRegion(spriteSheet, 896, 0, 64, 64);
        bearColor1Run1.flip(false, true);
        bearColor1Run2 = new TextureRegion(spriteSheet, 960, 0, 64, 64);
        bearColor1Run2.flip(false, true);
        bearColor1Run3 = new TextureRegion(spriteSheet, 1024, 0, 64, 64);
        bearColor1Run3.flip(false, true);
        bearColor1Run4 = new TextureRegion(spriteSheet, 1088, 0, 64, 64);
        bearColor1Run4.flip(false, true);

        TextureRegion[]  bearSlides1 = {bearColor1Run1, bearColor1Run2, bearColor1Run3, bearColor1Run4};
        runnerColor1BearAnim = new Animation(0.1f, bearSlides1);
        runnerColor1BearAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        bearColor1Jump = new TextureRegion(spriteSheet,1024, 0, 64, 64);
        bearColor1Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        bearColor1Idle = new TextureRegion(spriteSheet,1088, 0, 64, 64);
        bearColor1Idle.flip(false, true);


        //**********BEAR COLOR 2**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        bearColor2Run1 = new TextureRegion(spriteSheet, 896, 64, 64, 64);
        bearColor2Run1.flip(false, true);
        bearColor2Run2 = new TextureRegion(spriteSheet, 960, 64, 64, 64);
        bearColor2Run2.flip(false, true);
        bearColor2Run3 = new TextureRegion(spriteSheet, 1024, 64, 64, 64);
        bearColor2Run3.flip(false, true);
        bearColor2Run4 = new TextureRegion(spriteSheet, 1088, 64, 64, 64);
        bearColor2Run4.flip(false, true);

        TextureRegion[]  bearSlides2 = {bearColor2Run1, bearColor2Run2, bearColor2Run3, bearColor2Run4};
        runnerColor2BearAnim = new Animation(0.1f, bearSlides2);
        runnerColor2BearAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        bearColor2Jump = new TextureRegion(spriteSheet,1024, 64, 64, 64);
        bearColor2Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        bearColor2Idle = new TextureRegion(spriteSheet,1088, 64, 64, 64);
        bearColor2Idle.flip(false, true);


        //**********BEAR COLOR 3**********
        //*****WARRIOR RUNNING ANIMATION SETUP*****
        bearColor3Run1 = new TextureRegion(spriteSheet, 896, 128, 64, 64);
        bearColor3Run1.flip(false, true);
        bearColor3Run2 = new TextureRegion(spriteSheet, 960, 128, 64, 64);
        bearColor3Run2.flip(false, true);
        bearColor3Run3 = new TextureRegion(spriteSheet, 1024, 128, 64, 64);
        bearColor3Run3.flip(false, true);
        bearColor3Run4 = new TextureRegion(spriteSheet, 1088, 128, 64, 64);
        bearColor3Run4.flip(false, true);

        TextureRegion[]  bearSlides3 = {bearColor3Run1, bearColor3Run2, bearColor3Run3, bearColor3Run4};
        runnerColor3BearAnim = new Animation(0.1f, bearSlides3);
        runnerColor3BearAnim.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

        //*****WARRIOR JUMPING SETUP*****
        bearColor3Jump = new TextureRegion(spriteSheet, 1024, 128, 64, 64);
        bearColor3Jump.flip(false, true);

        //*****WARRIOR IDLE*****
        bearColor3Idle = new TextureRegion(spriteSheet, 1088, 128, 64, 64);
        bearColor3Idle.flip(false, true);

    }

    public static void setupSounds(){
        jump = Gdx.audio.newSound(Gdx.files.internal("data/jump.wav"));
        catchFish = Gdx.audio.newSound(Gdx.files.internal("data/pickup_coin.wav"));
        death = Gdx.audio.newSound(Gdx.files.internal("data/death.wav"));
        click = Gdx.audio.newSound(Gdx.files.internal("data/click_button.wav"));
        unlock = Gdx.audio.newSound(Gdx.files.internal("data/unlock.wav"));
        splash = Gdx.audio.newSound(Gdx.files.internal("data/splash.wav"));
    }

    public static void setHighScore(int score){
        preferences.putInteger("highscore",score);
        preferences.flush(); //saves the preference (*)
    }
    public static int getHighScore(){
        return preferences.getInteger("highscore");
    }
    public static void incrementTotalFish(int score){
        prevscore = preferences.getInteger("totalFish");
        Gdx.app.log("total_fish_check", "Prev total fish: " + prevscore + "");
        Gdx.app.log("total_fish_check", "Score: " + score + "");
        prevscore = prevscore + score;
        if(prevscore >= 999999){
            prevscore = 999999;
        }
        preferences.putInteger("totalFish", prevscore);

        preferences.flush();
    }
    public static int getTotalFish(){
        return preferences.getInteger("totalFish");}

    public static void deincrementTotalFish(int value){
        prevscore = preferences.getInteger("totalFish");
        Gdx.app.log("total_fish_check", "Prev total fish: " + prevscore + "");
        Gdx.app.log("total_fish_check", "Value: " + value + "");
        prevscore = prevscore - value;
        preferences.putInteger("totalFish", prevscore);

        preferences.flush();
    }

    public static void muteSound(boolean muteS){
        preferences.putBoolean("muteState", muteS);
        preferences.flush();
    }

    public static boolean getMuteState(){
        Gdx.app.log("mute", preferences.getBoolean("muteState") + "");
        return preferences.getBoolean("muteState");
    }

    public static  void incrementSelector(){
        if(characterSelector >= NUMBEROFCHARACTERS){
            characterSelector = 0;
        }
        else
            characterSelector ++;
    }

    public static void deincrementSelector(){
        if(characterSelector <= 0){
            characterSelector = NUMBEROFCHARACTERS;
        }
        else
            characterSelector --;
    }

    public static int getCharacterSelector() {
        return characterSelector;
    }

    public static void setCharacterSelector(int val){
        characterSelector = val;
    }

    public static void setCharacter(int selector){
        preferences.putInteger("charSelect",selector);
        preferences.flush();
    }
    public static int getCharacter(){
        return preferences.getInteger("charSelect");
    }
    public static boolean purchaseCharacter(int purchaseCost){
        if(getTotalFish() >= purchaseCost){
            deincrementTotalFish(purchaseCost);
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean canPurchase(int purchaseCost){
        if(getTotalFish() >= purchaseCost){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getCharacterPrice(int selector){
        switch (selector) {
            case 0:
                return 0;
            case 1:
                return RUNNER_COST;
            case 2:
                return RUNNER_COST;
            case 3:
                return RUNNER_COST;
            default:
                return -1;
        }
    }


    public static void unlockCharacter(int selector){
        switch (selector){
            case 0:
                if(purchaseCharacter(RUNNER_COST)) {
                    preferences.putBoolean("runner_1", true);
                }
                break;
            case 1:
                if(purchaseCharacter(RUNNER_COST)) {
                    preferences.putBoolean("runner_2", true);
                }
                break;
            case 2:
                if(purchaseCharacter(RUNNER_COST)) {
                    preferences.putBoolean("runner_3", true);
                }
                break;
            case 3:
                if(purchaseCharacter(RUNNER_COST)) {
                    preferences.putBoolean("runner_4", true);
                }
                break;
            default:
                Gdx.app.log("unlock", "default triggered");
        }
        preferences.flush();
    }

    public static boolean isUnlocked(int selector){
        if(mgame.getActionResolver().getPremiumInfo()){
            return true; //Return true, all characters unlocked!
        }
        switch (selector) {
            case 0:
                return preferences.getBoolean("runner_1");
            case 1:
                return preferences.getBoolean("runner_2");
            case 2:
                return preferences.getBoolean("runner_3");
            case 3:
                return preferences.getBoolean("runner_4");
            default:
                return false; //Other characters are locked because the user has not purchased a premium account.
        }
    }

    public static void clearPreferences(){
        preferences.clear();
        preferences.putBoolean("runner_1",true);
        preferences.flush();
    }

    public static void dispose(){
        //Dispose of textures
        spriteSheet.dispose();
        sky.dispose();

        //Dispose of fonts
        ocra.dispose();
        bitfontsmall.dispose();
        //Dispose of sounds
        jump.dispose();
        catchFish.dispose();
        death.dispose();
        click.dispose();
        unlock.dispose();
        splash.dispose();
    }
}
