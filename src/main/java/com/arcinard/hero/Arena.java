package com.arcinard.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

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

    public void draw(Screen screen) {
        screen.setCharacter(hero.get_X(), hero.get_Y(), TextCharacter.fromCharacter('H')[0]);
    }
    public boolean canHeroMove(Position position){
        int fx = position.getX();
        int fy = position.getY();
        return fx >= 0 && fx < width && fy >= 0 && fy < this.height;
    }
}

