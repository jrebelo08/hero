package com.arcinard.hero;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Coin extends Element{
    Coin(int x, int y){
        super(x,y);
    }
    @Override
    public void draw(TextGraphics textGraphics) {
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#999111"));
        Position coinPosition = getPosition();
        textGraphics.setCharacter(coinPosition.getX(), coinPosition.getY(),'C');
    }
}
