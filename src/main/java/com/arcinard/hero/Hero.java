package com.arcinard.hero;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element{


    Hero(int x, int y ){
        super(x,y);
    }
    public int get_X() {
        return position.getX();
    }
    public int get_Y() {
        return position.getY();
    }
    public void set_X(int x) {
        this.position.x = x;
    }

    public void set_Y(int y) {
        this.position.y = y;
    }

    public Position moveUp(){
        return new Position(get_X(), get_Y() - 1);
    }
    public Position moveDown(){
        return new Position(get_X(), get_Y() + 1);
    }
    public Position moveRight(){
        return new Position(get_X() + 1, get_Y());
    }
    public Position moveLeft(){
        return new Position(get_X() - 1, get_Y());
    }
    public void setPosition(Position position){
        this.position = position;
    }
    public void draw(TextGraphics textGraphics){
        textGraphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        textGraphics.enableModifiers(SGR.BOLD);
        textGraphics.putString(new TerminalPosition(position.getX(), position.getY()), "H");
    }
}
