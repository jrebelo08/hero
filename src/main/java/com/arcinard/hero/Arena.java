package com.arcinard.hero;

import java.util.List;
import java.util.ArrayList;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import java.util.Random;


import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;

    Hero hero = new Hero(10,10);
    Arena(int width,int height){
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
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
        retrieveCoins();
    }

    public void moveHero(Position position) {
        if (canHeroMove(position))
            hero.setPosition(position);
    }
    public void draw(TextGraphics textGraphics){
        textGraphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        textGraphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(textGraphics);
        for (Wall wall : walls)
            wall.draw(textGraphics);
        for (Coin coin : coins)
            coin.draw(textGraphics);
    }

    public boolean canHeroMove(Position position){
        for(Wall wall: walls) {
            if (wall.getPosition().equals(position)) {
                return false;
            }
        }
        int fx = position.getX();
        int fy = position.getY();
        return fx >= 0 && fx < width && fy >= 0 && fy < this.height;
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1,
                    random.nextInt(height - 2) + 1));
        return coins;
    }
    private void retrieveCoins() {
        List<Coin> coinsToRemove = new ArrayList<>();
        Position heroPosition = hero.getPosition();

        for (Coin coin : coins) {
            if (coin.getPosition().equals(heroPosition)) {
                coinsToRemove.add(coin);
            }
        }

        coins.removeAll(coinsToRemove);
    }
}
