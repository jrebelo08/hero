package com.arcinard.hero;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {
    Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics textGraphics) {
        textGraphics.putString(position.getX(), position.getY(), "M");
    }

    public Position move() {
        Random random = new Random();
        int direction = random.nextInt(4);

        int newX = get_X();
        int newY = get_Y();

        switch (direction) {
            case 0:
                newY -= 1;
                break;
            case 1:
                newY += 1;
                break;
            case 2:
                newX -= 1;
                break;
            case 3:
                newX += 1;
                break;
        }
        return new Position(newX, newY);
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public int get_X() {
        return position.getX();
    }
    public int get_Y() {
        return position.getY();
    }

}
