package com.arcinard.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall extends Element {
    Wall(int x, int y){
        super(x, y);
    }
    public Position getPosition(){
        return position;
    }
    public void draw(TextGraphics textGraphics){
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#434234"));
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY()), "W");
    }
}
