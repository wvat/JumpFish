package com.project.jumpfish.game;

/**
 * Created by Fred on 06/08/2015.
 */
public interface ActionResolver {
    public boolean getPremiumInfo();
    public void buyPremium();
    public void rate();
    public void showAd();
    public String getVerNum();
}
