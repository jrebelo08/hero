package com.arcinard.hero;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;


import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    Hero hero = new Hero(10,10);
    Arena(int width,int height){
        this.width = width;
        this.height = height;
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> {
                moveHero(hero.moveUp());
            }
            case ArrowDown -> {
                moveHero(hero.moveDown());
            }
            case ArrowRight -> {
                moveHero(hero.moveRight());
            }
            case ArrowLeft -> {
                moveHero(hero.moveLeft());
            }
        }
        if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q'){
            try{
                Game.screen.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void draw(TextGraphics textGraphics){
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(new TerminalPosition(hero.get_X(), hero.get_Y()), "H");
    }

    public boolean canHeroMove(Position position){
        int fx = position.getX();
        int fy = position.getY();
        return fx >= 0 && fx < width && fy >= 0 && fy < this.height;
    }
}

