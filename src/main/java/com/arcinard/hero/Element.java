package com.arcinard.hero;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    Element(int x, int y) {
        this.position = new Position(x, y);
    }
    public abstract void draw(TextGraphics textGraphics);
    public Position getPosition() {
        return position;
    }
}
